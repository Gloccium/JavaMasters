package lr7;

import java.io.*;

class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

public class Example13 {
    public static void main(String[] args) {
        String fileName = "person.ser";

        // Создание и запись объекта в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Person person = new Person("Ivan Ivanov", 30, "male");
            out.writeObject(person);
            System.out.println("Объект записан в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }

        // Чтение объекта из файла
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Person restoredPerson = (Person) in.readObject();
            System.out.println("Имя: " + restoredPerson.name);
            System.out.println("Возраст: " + restoredPerson.age);
            System.out.println("Пол: " + restoredPerson.gender);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
