package lr3;

import java.util.HashMap;

public class task5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        StringBuilder keysGreaterThanFive = new StringBuilder();
        StringBuilder keysEqualToZero = new StringBuilder();
        int productOfKeys = 1;
        boolean foundLengthGreaterThanFive = false;

        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                if (keysGreaterThanFive.length() > 0) keysGreaterThanFive.append(", ");
                keysGreaterThanFive.append(entry.getValue());
            }
            if (entry.getKey() == 0) {
                if (keysEqualToZero.length() > 0) keysEqualToZero.append(", ");
                keysEqualToZero.append(entry.getValue());
            }
            if (entry.getValue().length() > 5) {
                productOfKeys *= entry.getKey();
                foundLengthGreaterThanFive = true;
            }
        }

        System.out.println("Строки с ключом > 5: " + keysGreaterThanFive);
        System.out.println("Строки с ключом = 0: " + keysEqualToZero);
        if (foundLengthGreaterThanFive) {
            System.out.println("Произведение ключей с длиной строки > 5: " + productOfKeys);
        } else {
            System.out.println("Нет строк с длиной > 5");
        }
    }
}
