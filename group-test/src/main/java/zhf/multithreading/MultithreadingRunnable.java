package zhf.multithreading;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class MultithreadingRunnable implements Runnable {

    private static int count;

    public MultithreadingRunnable() {
        count = 0;
    }

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

}
