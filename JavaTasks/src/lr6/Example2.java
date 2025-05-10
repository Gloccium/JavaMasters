package lr6;

public class Example2 {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
