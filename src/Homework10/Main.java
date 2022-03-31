package Homework10;

import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Student> listOfStudent = new HashMap<>();
    private static int index = 1;

    private static String input(Scanner scanner) {
        String inputText;
        while (true) {
            inputText = scanner.nextLine();
            if (inputText.equals("") || inputText.equals(" ")) {
                System.out.println("Строка не может быть пустой!");
                continue;
            } else {
                return inputText;
            }
        }
    }

    private static int menu() {
        System.out.println("Выберите пункт меню:");
        int choice;
        while (true) {
            System.out.println("1. Добавить ученика;\n2. Вывести всех учеников по возрастанию;\n3. Вывести всех учеников по убыванию;" +
                    "\n4. Удалить ученика по индексу;\n5. Завершить программу.\n");
            try {
                choice = Integer.parseInt(input(sc));
            } catch (NumberFormatException e) {
                System.out.println("Для выбора меню допустим только цифровой ввод от 1 до 5 включительно!");
                continue;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Вы выбрали: " + choice + "\nВариантов выбора меню: от 1 до 5 включительно");
                continue;
            }
            return choice;
        }
    }

    private static boolean action(int choice) {
        switch (choice) {
            case 1:
                insertNewStudent();
                return true;
            case 2:
                outputListOnFullName();
                return true;
            case 3:
                outputListOnFullNameReverse();
                return true;
            case 4:
                deleteStudent();
                return true;
            default:
                return false;
        }
    }

    private static void insertNewStudent() {
        Student student;
        FullName fullName;
        Subject favoriteSubject;
        while (true) {
            System.out.println("Введите полное имя студента:");
            System.out.print("Фамилия: ");
            String surname = input(sc);
            System.out.print("\nИмя: ");
            String name = input(sc);
            System.out.print("\nОтчество: ");
            String patronymic = input(sc);
            System.out.println();
            if (checkOnLetter(name) && checkOnLetter(surname) && checkOnLetter(patronymic)) {
                fullName = new FullName(surname, name, patronymic);
                break;
            } else {
                System.out.println("В имени студента не может быть цифр или спецсимволов!");
                continue;
            }
        }
        int age;
        int grade;
        while (true) {
            System.out.println("Введите возраст студента и класс:");
            try {
                System.out.print("Возраст: ");
                age = Integer.parseInt(input(sc));
                System.out.print("\nКласс: ");
                grade = Integer.parseInt(input(sc));
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Возраст и класс студента записывается только числами!");
                continue;
            }
            if (age < 18 || age > 100) {
                System.out.println("Студент не может быть моложе 18 либо старше 100 лет!");
                continue;
            }
            if (grade < 1 || grade > 11) {
                System.out.println("В заведении существуют классы с 1 по 11!");
                continue;
            }
            break;
        }
        while (true) {
            int choice;
            System.out.println("Выберите любимый предмет студента: 1. Физика; 2. Биология; 3. География.");
            try {
                choice = Integer.parseInt(input(sc));
            } catch (NumberFormatException e) {
                System.out.println("Для выбора допустим только цифровой ввод от 1 до 3 включительно!");
                continue;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Доступно только три предмета");
                continue;
            }
            if (choice == 1) {
                favoriteSubject = Subject.PHYSICS;
            } else if (choice == 2) {
                favoriteSubject = Subject.BIOLOGY;
            } else {
                favoriteSubject = Subject.GEOGRAPHY;
            }
            break;
        }
        student = new Student(fullName, age, grade, favoriteSubject);
        listOfStudent.put(index, student);
        System.out.println("Новый студент занесен в картотеку за номером: " + index);
        index++;
    }

    private static void outputListOnFullName() {
        if (listOfStudent.isEmpty()) {
            System.out.println("В картотеке нет ни одной записи!");
            return;
        }
        List<Student> tempList = new ArrayList<>(listOfStudent.values());
        tempList.sort(new StudentSurnameComparator().thenComparing(new StudentNameComparator()).thenComparing(new StudentPatronymicComparator()));
        for (Student s: tempList) {
            System.out.println(s);
        }
    }

    private static void outputListOnFullNameReverse() {
        if (listOfStudent.isEmpty()) {
            System.out.println("В картотеке нет ни одной записи!");
            return;
        }
        List<Student> tempList = new ArrayList<>(listOfStudent.values());
        tempList.sort(new StudentSurnameComparator().thenComparing(new StudentNameComparator()).thenComparing(new StudentPatronymicComparator()));
        Collections.reverse(tempList);
        for (Student s: tempList) {
            System.out.println(s);
        }
    }

    private static void deleteStudent() {
        if (listOfStudent.isEmpty()) {
            System.out.println("В картотеке нет ни одной записи!");
            return;
        }
        System.out.println("Удаление студента из картотеки доступно только по его индексу.");
        while (true) {
            System.out.println("Желаете просмотреть всех? Y / N");
            String answer = input(sc);
            if (!answer.equals("Y") && !answer.equals("N")) {
                System.out.println("Некорректный ввод!");
                continue;
            }
            if (answer.equals("Y")) outputAllStudents();
            break;
        }
        int index;
        while (true) {
            System.out.println("Выберите студента, которого нужно удалить из картотеки.");
            try {
                System.out.print("Введите индекс: ");
                index = Integer.parseInt(input(sc));
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Для ввода доступно только число!");
                continue;
            }
            break;
        }
        if (!listOfStudent.containsKey(index)) {
            System.out.println("Студент с индексом " + index + " не найден!");
        } else {
            listOfStudent.remove(index);
        }
    }

    private static void outputAllStudents() {
        for (Map.Entry<Integer, Student> map : listOfStudent.entrySet()) {
            int index = map.getKey();
            Student student = map.getValue();
            System.out.println("Студент: " + student + "; Его индекс: " + index);
        }
    }

    private static boolean checkOnLetter(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        while (action(menu())) ;
        System.out.println("Программа завершена.");
        sc.close();

    }

    static class StudentSurnameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFullName().getSurname().compareTo(o2.getFullName().getSurname());
        }
    }

    static class StudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFullName().getName().compareTo(o2.getFullName().getName());
        }
    }

    static class StudentPatronymicComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFullName().getPatronymic().compareTo(o2.getFullName().getPatronymic());
        }
    }

}
