package lr7;

import java.io.File;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не найден или это не файл.");
        }
    }
}