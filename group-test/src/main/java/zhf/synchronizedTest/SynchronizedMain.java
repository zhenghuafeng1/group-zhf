package zhf.synchronizedTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMain {

    public static void main(String[] args) {


        ExecutorService executorService= Executors.newFixedThreadPool(10);

        RunnableMethod runnableMethod=new RunnableMethod();

        for(int i=0;i<5;i++){
            executorService.execute(runnableMethod);
        }



    }

}
