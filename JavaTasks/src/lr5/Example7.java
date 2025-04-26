package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        String[] input = scanner.nextLine().split("\\s+");
        List<String> strings = Arrays.asList(input);

        List<String> result = filterCapitalizedStrings(strings);
        System.out.println(result);
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}