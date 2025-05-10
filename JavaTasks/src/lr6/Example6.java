package lr6;

import java.util.concurrent.*;

public class Example6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        int chunkSize = (int) Math.ceil((double) array.length / cores);
        Future<Integer>[] futures = new Future[cores];

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            futures[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            });
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        System.out.println(totalSum);
    }
}
