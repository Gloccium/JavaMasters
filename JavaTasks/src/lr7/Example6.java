package lr7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        String outputFile = "src/1r7/example/output.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для записи в файл:");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while (!(line = scanner.nextLine()).isEmpty()) {
                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
            }

            System.out.println("Данные записаны в файл: " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}