package lr5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите элементы первого массива через пробел: ");
        String[] input1 = scanner.nextLine().split("\\s+");
        int[] arr1 = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();

        System.out.print("Введите элементы второго массива через пробел: ");
        String[] input2 = scanner.nextLine().split("\\s+");
        int[] arr2 = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

        int[] result = findCommonElements(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        return Arrays.stream(arr2)
                .filter(set1::contains)
                .toArray();
    }
}
