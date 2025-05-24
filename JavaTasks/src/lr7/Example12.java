package lr7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название файла:");
        String fileName = scanner.nextLine();

        System.out.println("Введите текст для записи в файл:");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Количество записанных символов: " + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
