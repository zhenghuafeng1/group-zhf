package zhf.singleThreadExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("线程池测试开始执行！");


        ExecutorService threadExecutor= Executors.newSingleThreadExecutor();

        for(int i=0;i<10;i++){
            threadExecutor.execute(new ThreadPool());
        }
        threadExecutor.shutdown();




        System.out.println("线程池测试执行完毕！");
    }
}
