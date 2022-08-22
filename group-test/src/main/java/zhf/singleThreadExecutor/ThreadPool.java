package zhf.singleThreadExecutor;

public class ThreadPool implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":执行完毕");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
