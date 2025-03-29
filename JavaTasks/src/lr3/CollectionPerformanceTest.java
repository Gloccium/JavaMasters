package lr3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeMap;

public class CollectionPerformanceTest {
    public static void main(String[] args) {
        int collectionSize = 2000000;
        long indexAccessCount = 2000000000L;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            arrayDeque.addFirst(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время добавления в начало ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            treeMap.put(i, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            arrayList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в ArrayList: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            arrayDeque.add(arrayDeque.size() / 2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в середину ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            treeMap.put(collectionSize / 2 + i, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в середину TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в середину ArrayList: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            arrayDeque.addLast(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в конец ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            treeMap.put(collectionSize + i, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в конец TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < collectionSize; i++) {
            arrayList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время добавления в конец ArrayList: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!arrayDeque.isEmpty()) {
            arrayDeque.removeFirst();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из начала ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!treeMap.isEmpty()) {
            treeMap.pollFirstEntry();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из начала TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из начала ArrayList: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!arrayDeque.isEmpty()) {
            arrayDeque.remove(arrayDeque.size() / 2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из середины ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!treeMap.isEmpty()) {
            treeMap.remove(treeMap.size() / 2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из середины TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() / 2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из середины ArrayList: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!arrayDeque.isEmpty()) {
            arrayDeque.removeLast();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из конца ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!treeMap.isEmpty()) {
            treeMap.pollLastEntry();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из конца TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время удаления из конца ArrayList: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (long i = 0; i < indexAccessCount; i++) {
            if (!arrayDeque.isEmpty()) {
                arrayDeque.getFirst();
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время получения элемента по индексу из ArrayDeque: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (long i = 0; i < indexAccessCount; i++) {
            if (!treeMap.isEmpty()) {
                treeMap.get((int) (i % collectionSize));
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время получения элемента по индексу из TreeMap: " + (endTime - startTime) + " мс");

        startTime = System.currentTimeMillis();
        for (long i = 0; i < indexAccessCount; i++) {
            if (!arrayList.isEmpty()) {
                arrayList.get((int) (i % collectionSize));
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Время получения элемента по индексу из ArrayList: " + (endTime - startTime) + " мс");
    }
}
