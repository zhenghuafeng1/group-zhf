package zhf.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMain {
    public static void main(String[] args) {
        Thread thread=new Thread(new Multithreading());
        thread.start();

        MultithreadingRunnable multithreadingRunnable=new MultithreadingRunnable();
        Thread runnable=new Thread(multithreadingRunnable);
        runnable.start();

        FutureTask<String> future = new FutureTask<>(new MultithreadingCallable());
        Thread callable=new Thread(future);
        callable.start();
    }
}
