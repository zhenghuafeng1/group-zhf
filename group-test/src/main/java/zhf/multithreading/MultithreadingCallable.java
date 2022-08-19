package zhf.multithreading;

import java.util.concurrent.Callable;

public class MultithreadingCallable implements Callable {
    @Override
    public Object call() throws Exception {

        for(int i=0;i<10;i++){
            System.out.println("this is Callable");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Callable";
    }
}
