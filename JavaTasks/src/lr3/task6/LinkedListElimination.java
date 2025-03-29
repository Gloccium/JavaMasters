package lr3.task6;

import java.util.LinkedList;

public class LinkedListElimination {
    public static void main(String[] args) {
        int N = 10;
        LinkedList<Integer> people = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        System.out.println("Оставшийся человек (LinkedList): " + people.getFirst());
    }
}