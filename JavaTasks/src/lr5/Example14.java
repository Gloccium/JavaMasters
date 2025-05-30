package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Введите максимальное значение:");
        int maxValue = Integer.parseInt(scanner.nextLine());

        List<Integer> result = filterLessThan(numbers, maxValue);
        System.out.println(result);
    }

    public static List<Integer> filterLessThan(List<Integer> numbers, int maxValue) {
        return numbers.stream()
                .filter(n -> n < maxValue)
                .collect(Collectors.toList());
    }
}
