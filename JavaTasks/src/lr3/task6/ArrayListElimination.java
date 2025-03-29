package lr3.task6;

import java.util.ArrayList;

public class ArrayListElimination {
    public static void main(String[] args) {
        int N = 10;
        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        System.out.println("Оставшийся человек (ArrayList): " + people.get(0));
    }
}
