package Homework8;

import java.util.Scanner;

public class Main {

    private static boolean isStopped = true;

    private static String input (Scanner sc) {
        return sc.nextLine();
    }

    private static void checkInput (String line) throws InputException {
        char[] lineArr = line.toCharArray();

        for (int i = 0; i < lineArr.length; i++) {
            char sample = lineArr[i];
            if (Character.isDigit(sample)) throw new InputException("В строке обнаружена цифра!", line, sample);
            if (i != 0 && i < lineArr.length -1 && sample == lineArr[i - 1] && sample == lineArr[i] && sample == lineArr[i + 1])
                throw  new InputException("В строке обнаружен повторяющийся более 3-х раз подряд символ!", line, sample);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testLine;
        while (isStopped) {
            System.out.println("Введите строку или слово \"exit\" для завершения программы:");
            testLine = null;
            testLine = input(scanner);
            try {
                checkInput(testLine);
            } catch (InputException ie) {
                System.out.println(ie.getMessage() + " " + ie.getDesired());
                System.out.println("Программа завершена");
                testLine = null;
                isStopped = false;
            }
            if (testLine != null && testLine.equals("exit")){
                System.out.println("Программа завершена");
                isStopped = false;
            }
            if (testLine != null) System.out.println("Введенная строка: " + testLine);
        }
        scanner.close();
    }

}
