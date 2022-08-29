package zhf.ThreadLocalTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalMain {


    public static ThreadLocal<Integer> ti = new ThreadLocal<Integer>();

    public static void main(String[] args) {

        ExecutorService executor= Executors.newCachedThreadPool();

//        executor.execute(()->{
//            ti.set(1);
//            System.out.println(Thread.currentThread().getName()+": "+ti.get());
//            System.gc();
//            System.out.println(Thread.currentThread().getName()+": "+ti.get());
//        });
//
//        executor.execute(()->{
//            System.out.println(Thread.currentThread().getName()+": "+ti.get());
//        });

        new Thread(new Runnable() {
            @Override
            public void run() {
            ti.set(1);
            System.out.println(Thread.currentThread().getName()+": "+ti.get());
            System.gc();
            System.out.println(Thread.currentThread().getName()+": "+ti.get());
            }
        }).start();
    }
}
