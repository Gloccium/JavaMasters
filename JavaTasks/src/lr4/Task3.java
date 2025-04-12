package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов массива: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new IllegalArgumentException("Количество элементов должно быть положительным.");
            }

            byte[] array = new byte[n];
            System.out.println("Введите элементы массива (диапазон -128 до 127):");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextByte();
            }

            int sum = calculateSum(array);
            System.out.println("Сумма элементов массива: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введено некорректное значение. Ожидается число типа byte.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static int calculateSum(byte[] array) throws ArithmeticException {
        int sum = 0;
        for (byte num : array) {
            sum += num;
        }
        return sum;
    }
}