package Homework2;

import java.util.Scanner;

/**
 * С клавиатуры вводится двумерный массив, длина его строк – 4, столбцов – 3.
 * <p>
 * 1.Напишите программу, которая выводит номера строк и суммы их элементов (пример: Line 2: 17).
 * <p>
 * 2.Напишите программу, которая выводит номера столбцов и суммы их элементов (пример: Column 3: 21).
 * <p>
 * 3.Напишите программу, которая заменяет все нечётные элементы массива на 1, а чётные на 0 и выводит его на экран.
 * <p>
 * 4.Напишите программу, которая для в каждой строке находит целое среднее арифметическое и выводит его на экран.
 * <p>
 * 5.***Напишите программу, которая преобразует двумерный массив в перевёрнутый одномерный и выводит все элементы одномерного массива на экран.
 */

public class Task2 {

    public static void main(String[] args) {
//        int[][] arr = {{13, 26, 9}, {7, 11, 70}, {1, 3, 10}, {2, 4, 6}};  //Тестовый массив, чтобы много раз не заполнять руками.
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Номера строк и сумма их элементов:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Строка номер " + (i + 1));
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
            System.out.print(", ее сумма = " + sum + "\n");
        }

        System.out.println("Номера столбцов и сумма их элементов:");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print("Столбец номер " + (i + 1));
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            System.out.print(", его сумма = " + sum + "\n");
        }

        System.out.println("Поиск целого среднего арифметического строки:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Строка номер " + (i + 1));
            int average = 0;
            for (int j = 0; j < arr[0].length; j++) {
                average += arr[i][j];
            }
            average /= arr[i].length;
            System.out.print(", ее среднее арифметическое = " + average + "\n");
        }

        System.out.println("Преобразование двумерного массива в перевернутый одномерный:");
        int[] arr2 = new int[(arr.length * arr[0].length)];
        int counter = 0;
        while ((arr2.length - counter) != 0) {
            for (int i = arr.length - 1; i != -1; i--) {
                for (int j = arr[0].length - 1; j != -1; j--) {
                    arr2[counter] = arr[i][j];
                    System.out.print(arr2[counter] + " ");
                    counter++;
                }
            }
        }

        System.out.println("\nЗамена нечетных элементов массива на 1, а четных элементов на 0");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] % 2 == 0) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
