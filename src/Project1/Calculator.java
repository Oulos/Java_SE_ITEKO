package Project1;

import java.util.Scanner;

public class Calculator {

    private static Scanner sc = new Scanner(System.in);
    final private static char[] actions = {'+', '-', '*', '/', '?', '!', '^'};  //Массив символов всех доступных операций для проверки ввода.
    private static String result = null;    //Глобальная переменная для хранения результата вычислений.

    public static String input(Scanner scanner) {
        return scanner.nextLine();
    }

    //Пользователь выбирает действие из меню.
    public static void showMenu() {
        boolean isStopped = false;
        while (!isStopped) {
            System.out.println("1. Ввести пример.\n2. Продолжить работать с предыдущим ответом.\n3. Выход.");
            String choice = input(sc);
            switch (choice) {
                case ("1"):
                    result = null;
                    workWithExample();
                    break;
                case ("2"):
                    if (result == null) {
                        System.out.println("Недоступно! Или выполнялось сравнение.");
                        continue;
                    } else {
                        workWithAnswer(result);
                    }
                    break;
                case ("3"):
                    isStopped = true;
                    break;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }

    //Пользователь вводит пример
    public static void workWithExample() {
        while (true) {
            String example = inputExample();
            String[] arr = example.split(" ");
            if (!checkExample(arr)) {
                System.out.println("Некорректный ввод! Передано невыполнимое действие или введена буква или отсутствует второе число.");
                continue;
            }
            if (arr[1].equals("?")) {
                comparison(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]));
                result = null;
                break;
            } else if (arr[1].equals("!")) {
                System.out.printf("\"%s\" - %s%s = ", arr[1], arr[0], arr[1]);
                factorial(Integer.parseInt(arr[0]));
                break;
            } else {
                result = operation(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), arr[1]);
                if (result != null) {
                    output(arr[0], arr[2], arr[1]);
                    break;
                } else {
                    continue;
                }
            }
        }
    }

    public static String inputExample() {
        while (true) {
            System.out.println("Введите пример для вычисления.");
            String example = input(sc);
            if (example.equals("")) {
                System.out.println("Некорректный ввод! Пустая строка.");
                continue;
            } else {
                return example;
            }
        }
    }

    //Метод ввода числа, с которым будет произведено действие, выбранное из подменю работы с ответом.
    public static String inputAnotherNumber() {
        while (true) {
            System.out.println("Введите целочисленное значение.");
            String number = input(sc);
            if (number.equals("")) {
                System.out.println("Некорректный ввод! Пустая строка.");
                continue;
            } else if (!checkElement(number)) {
                System.out.println("Некорректный ввод! Недопустимые символы или дробное число.");
                continue;
            } else {
                return number;
            }
        }
    }

    //Проводится проверка ввода: разделенная на массив строка должна быть из 2х или 3х подстрок, содержать только числа и знак действия, совпадающий с одним из массива actions
    public static boolean checkExample(String[] arr) {
        if (arr.length < 2 || arr.length > 3) {
            return false;
        }
        if (arr.length == 2 && !checkElement(arr[0])) {
            return false;
        }
        if (arr.length == 3 && !checkElement(arr[0]) && !checkElement(arr[2])) {
            return false;
        }
        boolean isNotAction = false;
        for (int i = 0; i < actions.length; i++) {
            if (Character.toString(actions[i]).equals(arr[1])) {
                isNotAction = true;
                break;
            }
        }
        if (!isNotAction)
            return false;
        return true;
    }

    //Метод проверки введенного числа на наличие букв или спец символов.
    public static boolean checkElement(String element) {
        char[] arr = element.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] == '-') {
                continue;
            }
            if (!Character.isDigit(arr[i])) {
                return false;
            }
        }
        return true;
    }

    //Перегруженный метод проверки на наличие дробного числа. Вызывается только для проверки результата вычисления примера.
    public static boolean checkElement(String element, char c) {
        char[] arr = element.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                return false;
            }
        }
        return true;
    }

    //Метод вызывается, если запрошенное действие - не сравнение и не вычисление факториала. Вызывает подметоды с соответствующими операциями.
    public static String operation(int a, int b, String action) {
        switch (action) {
            case ("+"):
                return addition(a, b);
            case ("-"):
                return subtraction(a, b);
            case ("*"):
                return multiplication(a, b);
            case ("/"):
                if (b == 0) {
                    System.out.println("Недопустимая операция: деление на ноль!");
                    return null;
                } else {
                    return division(a, b);
                }
            case ("^"):
                return exponentiation(a, b);
            default:
                System.out.println("Недопустимая операция!");
                return null;
        }
    }

    //Методы и подметоды для дробных чисел, которые производят вычисления.
    public static String addition(int a, int b) {
        return String.valueOf(a + b);
    }

    public static String addition(double a, int b) {
        return String.valueOf(a + b);
    }

    public static String subtraction(int a, int b) {
        return String.valueOf(a - b);
    }

    public static String subtraction(double a, int b) {
        return String.valueOf(a - b);
    }

    public static String multiplication(int a, int b) {
        return String.valueOf(a * b);
    }

    public static String multiplication(double a, int b) {
        return String.valueOf(a * b);
    }

    public static String division(int dividend, int divider) {
        if (dividend % divider != 0) {
            double res = (double) dividend / divider;
            return String.valueOf(res);
        }
        return String.valueOf(dividend / divider);
    }

    public static String division(double dividend, int divider) {
        double res = (double) dividend / divider;
        return String.valueOf(res);
    }

    //Здесь и ниже - два связанных метода для возведения в степень. В методе запоминается итоговый результат, в подметоде рекурсивное вычисление.
    public static String exponentiation(int a, int b) {
        return String.valueOf(calculationExponentiation(a, b));
    }

    public static int calculationExponentiation(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        return a * calculationExponentiation(a, b - 1);
    }

    //Здесь и ниже - два связанных метода для вычисления факториала. В методе запоминается итоговый результат, в подметоде рекурсивное вычисление.
    public static void factorial(int number) {
        result = String.valueOf(calculationFactorial(number));
        System.out.print(" = " + result + "\n");
    }

    public static int calculationFactorial(int a) {
        if (a < 1) {
            return 0;
        }
        System.out.print(a);
        if (a == 1) {
            return 1;
        }
        System.out.print(" * ");
        return a * calculationFactorial(a - 1);
    }

    //Метод и подметод для дробного числа, которые производят сравнение.
    public static void comparison(int a, int b) {
        char sign;
        if (a > b) {
            sign = '>';
        } else if (a < b) {
            sign = '<';
        } else {
            sign = '=';
        }
        System.out.println("\"?\" - " + a + " ? " + b + " = " + a + " " + sign + " " + b);
    }

    public static void comparison(double a, int b) {
        char sign;
        if (a > b) {
            sign = '>';
        } else if (a < b) {
            sign = '<';
        } else {
            sign = '=';
        }
        System.out.println("\"?\" - " + a + " ? " + b + " = " + a + " " + sign + " " + b);
    }

    //Вывод результата на экран.
    public static void output(String a, String b, String action) {
        System.out.printf("\" %s \" - %s %s %s = " + result + "\n", action, a, action, b);
    }

    //Пользователь выбирает действие для работы с предыдущим ответом.
    public static void workWithAnswer(String oldAnswer) {
        boolean isStopped = false;
        while (!isStopped) {
            System.out.println("Выберите действие:\n1. Сложение.\n2. Вычитание.\n3. Умножение.\n4. Деление.\n5. Факториал." +
                    "\n6. Возведение в степень.\n7. Сравнение.\n0. Назад.");
            isStopped = true;
            String choice = input(sc);
            String number;
            System.out.println("Результат предыдущих вычислений: " + oldAnswer);
            switch (choice) {
                case ("1"):
                    System.out.println("На сколько увеличить предыдущий результат?");
                    number = inputAnotherNumber();
                    if (checkElement(oldAnswer, '.')) {
                        result = addition(Integer.parseInt(oldAnswer), Integer.parseInt(number));
                    } else {
                        result = addition(Double.parseDouble(oldAnswer), Integer.parseInt(number));
                    }
                    output(oldAnswer, number, "+");
                    break;
                case ("2"):
                    System.out.println("На сколько уменьшить предыдущий результат?");
                    number = inputAnotherNumber();
                    if (checkElement(oldAnswer, '.')) {
                        result = subtraction(Integer.parseInt(oldAnswer), Integer.parseInt(number));
                    } else {
                        result = subtraction(Double.parseDouble(oldAnswer), Integer.parseInt(number));
                    }
                    output(oldAnswer, number, "-");
                    break;
                case ("3"):
                    System.out.println("Во сколько увеличить предыдущий результат?");
                    number = inputAnotherNumber();
                    if (checkElement(oldAnswer, '.')) {
                        result = multiplication(Integer.parseInt(oldAnswer), Integer.parseInt(number));
                    } else {
                        result = multiplication(Double.parseDouble(oldAnswer), Integer.parseInt(number));
                    }
                    output(oldAnswer, number, "*");
                    break;
                case ("4"):
                    System.out.println("Во сколько уменьшить предыдущий результат?");
                    number = inputAnotherNumber();
                    if (Integer.parseInt(number) == 0) {
                        System.out.println("Недопустимая операция: деление на ноль!");
                        isStopped = false;
                        break;
                    } else {
                        if (checkElement(oldAnswer, '.')) {
                            result = division(Integer.parseInt(oldAnswer), Integer.parseInt(number));
                        } else {
                            result = division(Double.parseDouble(oldAnswer), Integer.parseInt(number));
                        }
                        output(oldAnswer, number, "/");
                        break;
                    }
                case ("5"):
                    if (!checkElement(oldAnswer, '.')) {
                        System.out.println("В данной реализации факториал невозможно взять от дробного числа.");
                        isStopped = false;
                        break;
                    } else {
                        System.out.printf("\"!\" - %s! = ", oldAnswer);
                        factorial(Integer.parseInt(oldAnswer));
                        break;
                    }
                case ("6"):
                    System.out.println("В какую степень возвести предыдущий результат?");
                    number = inputAnotherNumber();
                    if (!checkElement(oldAnswer, '.') || !checkElement(number, '.')) {
                        System.out.println("В данной реализации невозможно возвести в степень дробное число или возвести в дробную степень.");
                        isStopped = false;
                        break;
                    } else {
                        result = exponentiation(Integer.parseInt(oldAnswer), Integer.parseInt(number));
                        output(oldAnswer, number, "^");
                    }
                    break;
                case ("7"):
                    System.out.println("С чем сравнить предыдущий результат?");
                    number = inputAnotherNumber();
                    if (checkElement(oldAnswer, '.')) {
                        comparison(Integer.parseInt(oldAnswer), Integer.parseInt(number));
                    } else {
                        comparison(Double.parseDouble(oldAnswer), Integer.parseInt(number));
                    }
                    result = null;
                    break;
                case ("0"):
                    System.out.println("Назад");
                    break;
                default:
                    System.out.println("Некорректный ввод!");
                    isStopped = false;
            }
        }
    }

    public static void main(String[] args) {
        showMenu();
        sc.close();
    }
}
