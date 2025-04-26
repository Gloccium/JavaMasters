package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> strings = Arrays.asList(scanner.nextLine().split("\\s+"));

        System.out.println("Введите минимальную длину строки:");
        int minLength = Integer.parseInt(scanner.nextLine());

        List<String> result = filterByLength(strings, minLength);
        System.out.println(result);
    }

    public static List<String> filterByLength(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
