package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> strings = Arrays.asList(scanner.nextLine().split("\\s+"));

        System.out.println("Введите подстроку для поиска:");
        String substring = scanner.nextLine();

        List<String> result = filterBySubstring(strings, substring);
        System.out.println(result);
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
