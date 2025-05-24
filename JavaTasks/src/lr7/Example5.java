package lr7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        String outputFile = "src/1r7/example/output.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные для записи в файл:");

        try (
                OutputStream outputStream = new FileOutputStream(outputFile);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ) {
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