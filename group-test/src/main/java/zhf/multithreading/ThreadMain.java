package zhf.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException{
//        Thread thread=new Thread(new Multithreading());
//        thread.start();
//
//        MultithreadingRunnable multithreadingRunnable=new MultithreadingRunnable();
//        Thread runnable=new Thread(multithreadingRunnable);
//        runnable.start();
//
//        FutureTask<String> future = new FutureTask<>(new MultithreadingCallable());
//        Thread callable=new Thread(future);
//        callable.start();

        // 创建线程池同时执行任务
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // 执行两次静态方法
//        threadPool.execute(new MultithreadingRunnable());

//        MultithreadingRunnable multithreadingRunnable=new MultithreadingRunnable();
//        Thread thread1 = new Thread(multithreadingRunnable, "Thread1");
//        Thread thread2 = new Thread(multithreadingRunnable, "Thread2");
//
//        thread1.start();
//        thread2.start();

        Thread thread1 = new Thread(new MultithreadingRunnable(), "Thread1");
        Thread thread2 = new Thread(new MultithreadingRunnable(), "Thread2");

        thread1.start();
        thread2.start();

    }

    /**
     * synchronized 修饰普通方法
     * 本方法的执行需要 3s（因为有 3s 的休眠时间）
     */
    public synchronized void method() {
        System.out.println("普通方法执行时间：" + LocalDateTime.now());
        try {
            // 休眠 3s
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void staticMethod() {
        System.out.println("静态方法执行时间：" + LocalDateTime.now());
    }
}
