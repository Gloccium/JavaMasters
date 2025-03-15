package lr2;


import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine();

        String encryptedText = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String choice = scanner.nextLine();

        while (true) {
            if (choice.equalsIgnoreCase("y")) {
                String decryptedText = decrypt(encryptedText, key);
                System.out.println("Текст после обратного преобразования: " + decryptedText);
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
                choice = scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'а' : 'А';
                if ((character >= 'а' && character <= 'я') || (character >= 'А' && character <= 'Я')) {
                    encryptedText.append((char) ((character - base + key) % 32 + base));
                } else {
                    encryptedText.append(character);
                }
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, 32 - key);
    }
}