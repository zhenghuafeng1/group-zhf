package zhf.singleThreadExecutor;

import java.util.concurrent.*;

public class SingleThreadExecutorMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("线程池测试开始执行！");


        /**
         * 单例化线程池
         */
//        ExecutorService threadExecutor= Executors.newSingleThreadExecutor();
//
//        for(int i=0;i<10;i++){
//            threadExecutor.execute(new ThreadPool());
//        }
//        threadExecutor.shutdown();


        ScheduledExecutorService threadExecutor=Executors.newScheduledThreadPool(3);
//        threadExecutor.schedule(new ThreadPool(),10, TimeUnit.SECONDS);
        threadExecutor.scheduleAtFixedRate(new ThreadPool(),10,3, TimeUnit.SECONDS);

        System.out.println("线程池测试执行完毕！");
    }
}
