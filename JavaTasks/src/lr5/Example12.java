package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Введите минимальное значение:");
        int minValue = Integer.parseInt(scanner.nextLine());

        List<Integer> result = filterGreaterThan(numbers, minValue);
        System.out.println(result);
    }

    public static List<Integer> filterGreaterThan(List<Integer> numbers, int minValue) {
        return numbers.stream()
                .filter(n -> n > minValue)
                .collect(Collectors.toList());
    }
}
