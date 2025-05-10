package lr6;

public class Example3 {
    public static void main(String[] args) {
        Runnable evenTask = () -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable oddTask = () -> {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread evenThread = new Thread(evenTask);
        Thread oddThread = new Thread(oddTask);

        evenThread.start();
        oddThread.start();
    }
}