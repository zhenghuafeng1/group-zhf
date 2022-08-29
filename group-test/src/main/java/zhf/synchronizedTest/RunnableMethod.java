package zhf.synchronizedTest;

public class RunnableMethod implements Runnable {


    @Override
    public void run() {
        runMethod();
    }

    public void runMethod(){
        synchronized (this){
        for(int i=1;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
        }
    }
    }

}
