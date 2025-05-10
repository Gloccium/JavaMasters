package lr6;

import java.util.concurrent.*;

public class Example5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {3, 7, 2, 9, 4, 10, 1, 6, 8, 5};
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        int chunkSize = (int) Math.ceil((double) array.length / cores);
        Future<Integer>[] futures = new Future[cores];

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            futures[i] = executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                return max;
            });
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            int localMax = future.get();
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        executor.shutdown();
        System.out.println(globalMax);
    }
}
