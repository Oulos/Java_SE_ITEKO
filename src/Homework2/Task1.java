package Homework2;

/**
 * Дан массив [3, 22, 1, 13, 4, 6, 16, 5], состоящий из целых чисел.
 * <p>
 * 1.Напишите программу, которая выводит (через пробел) те элементы массива, которые являются чётными числами.
 * <p>
 * 2.Напишите программу, которая выводит все двузначные числа массива.
 * <p>
 * 3.Напишите программу, которая выводит на экран наибольшее целое число этого массива.
 * <p>
 * 4.Напишите программу, которая считает сумму элементов массива и выводит её на экран.
 * <p>
 * 5.***Напишите программу, которая переворачивает массив в обратном порядке.
 */

public class Task1 {

    public static void main(String[] args) {

        int[] originalArray = {3, 22, 1, 13, 4, 6, 16, 5};

        System.out.println("Четные элементы массива:");
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] % 2 == 0) {
                System.out.print(originalArray[i] + " ");
            }
        }
        System.out.println("\nДвузначные элементы мавссива:");
        for (int i = 0; i < originalArray.length; i++) {
            int element = originalArray[i];
            if (element < 0) {
                element *= (-1);
            }
            if (element > 9 && element < 100) {
                System.out.print(originalArray[i] + " ");
            }
        }
        System.out.print("\nНаибольшее целое:");
        int max = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] > max) {
                max = originalArray[i];
            }
        }
        System.out.println(" " + max);
        System.out.print("Сумма элементов:");
        int sum = 0;
        for (int i = 0; i < originalArray.length; i++) {
            sum += originalArray[i];
        }
        System.out.println(" " + sum);
        System.out.println("Разворот массива:");
        for (int i = 0; i < (originalArray.length / 2); i++) {
            int temp = originalArray[i];
            originalArray[i] = originalArray[(originalArray.length - 1) - i];
            originalArray[(originalArray.length - 1) - i] = temp;
        }
        for (int i = 0; i < originalArray.length; i++) {
            System.out.print(originalArray[i] + " ");
        }
    }

}
