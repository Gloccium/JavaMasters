package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите количество строк матрицы: ");
            int rows = scanner.nextInt();
            System.out.print("Введите количество столбцов матрицы: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть положительными.");
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Введите номер столбца для вывода (начиная с 0): ");
            int colNumber = scanner.nextInt();

            printColumn(matrix, colNumber);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введено некорректное значение. Ожидается целое число.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Столбец с таким номером отсутствует.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void printColumn(int[][] matrix, int colNumber) throws ArrayIndexOutOfBoundsException {
        if (colNumber < 0 || colNumber >= matrix[0].length) {
            throw new ArrayIndexOutOfBoundsException("Неверный номер столбца.");
        }

        System.out.println("Элементы столбца " + colNumber + ":");
        for (int[] row : matrix) {
            System.out.println(row[colNumber]);
        }
    }
}
