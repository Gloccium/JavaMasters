package lr6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example1 {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 10000) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String time = sdf.format(new Date());
                System.out.println(threadName + ": " + time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
