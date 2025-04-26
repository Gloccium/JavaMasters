package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> strings = Arrays.asList(scanner.nextLine().split("\\s+"));

        List<String> result = filterAlphabeticStrings(strings);
        System.out.println(result);
    }

    public static List<String> filterAlphabeticStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
                .collect(Collectors.toList());
    }
}
