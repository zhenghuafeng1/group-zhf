package zhf.multithreading;

public class MultithreadingRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("this is Runnable");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
