package lr7;

import lr2.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите пол:");
        String gender = scanner.nextLine();

        try (
                FileOutputStream fileOut = new FileOutputStream("src/1r8/example/person.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            Person person = new Person(name, age, gender);
            out.writeObject(person);
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}