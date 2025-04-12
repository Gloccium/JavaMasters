package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов массива: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Количество элементов должно быть положительным.");
            }

            int[] array = new int[n];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            double average = calculateAverage(array);
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введено некорректное значение. Ожидается целое число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static double calculateAverage(int[] array) throws IllegalArgumentException {
        int sum = 0;
        int count = 0;
        for (int num : array) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Положительные элементы отсутствуют.");
        }
        return (double) sum / count;
    }
}