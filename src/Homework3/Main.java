package Homework3;

import java.util.Scanner;

/**
 * На вход подается строка с именем и числом. Необходимо написать метод, который будет складывать все цифры числа,
 * и приветствовать пользователя. Число как минимум должно иметь 2 разряда и максимум 5. Сумму цифр необходимо реализовать
 * при помощи рекурсии. Необходимо в программе реализовать конвертер чисел в названия, и выводить сумму цифр названием.
 * (сумма цифр не должна превышать 10 - для простоты реализации конвертора).
 * Важно! - первым параметром должно быть имя.
 * Для данной задачи понадобится метод строки .split(" ") - разделение элементов по маске. В нашем случае - это пробел.
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean unfinished = true;
        while (unfinished) {
            String originalString = input(sc);
            if (originalString.equals("")) {
                System.out.println("Некорректный ввод. Ничего не введено.");
                continue;
            }
            String[] words = originalString.split(" ");
            if (words.length != 2) {
                System.out.println("Некорректный ввод. Введено одно слово.");
                continue;
            }

            String firstWord = words[0];
            String secondWord = words[1];
            if (secondWord.length() < 2 || secondWord.length() > 5) {
                System.out.println("Некорректный ввод. Число имеет или меньше двух разрядов, или больше пяти.");
                continue;
            }
            if (!checkWord(firstWord, 0) || !checkWord(secondWord, 1)) {
                System.out.println("Некорректный ввод. В слове обнаружены цифры, или буквы в числе, или недопустимые символы.");
                continue;
            }
            int sum = sumOfDigits(Integer.parseInt(secondWord));
            if (sum > 10) {
                System.out.println("Некорректный ввод. Слишком большое число.");
                continue;
            }
            System.out.printf("Здравствуй, %s! Сумма цифр в числе = %s", firstWord, converter(sum));
            System.out.println("\nЖелаете повторить? Да/Нет");
            if (repeat(sc)) {
                continue;
            }
            System.out.println("\n Программа завершена.");
            unfinished = false;

        }
        sc.close();

    }

    public static String input(Scanner scanner) {
        return scanner.nextLine();
    }


    public static boolean checkWord(String word, int index) {
        char[] arr = word.toCharArray();
        boolean wordIsCorrect = true;
        boolean letter;
        boolean digit;
        for (int i = 1; i < arr.length; i++) {
            letter = Character.isLetter(arr[i - 1]);
            digit = Character.isDigit(arr[i]);
            if ((index == 0 && digit) || (letter && index == 1)) {
                wordIsCorrect = false;
                break;
            }
        }
        return wordIsCorrect;
    }

    public static int sumOfDigits(int number) {
        int sum = number % 10;
        if ((number / 10) == 0) {
            return sum;
        }
        return sum + (sumOfDigits(number / 10));
    }

    public static String converter(int number) {
        switch (number) {
            case (1):
                return "один";
            case (2):
                return "два";
            case (3):
                return "три";
            case (4):
                return "четыре";
            case (5):
                return "пять";
            case (6):
                return "шесть";
            case (7):
                return "семь";
            case (8):
                return "восемь";
            case (9):
                return "девять";
            case (10):
                return "десять";
            default:
                return "ОШИБКА! Сумма не подсчитана.";
        }
    }

    public static boolean repeat(Scanner scanner) {
        boolean result;
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("Да")) {
                result = true;
                break;
            } else if (answer.equals("Нет")) {
                result = false;
                break;
            } else {
                System.out.println("Некорректный ввод. Введите Да или Нет.");
                continue;
            }
        }
        return result;
    }

}
