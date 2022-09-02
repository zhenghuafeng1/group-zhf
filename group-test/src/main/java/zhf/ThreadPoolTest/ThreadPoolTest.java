package zhf.ThreadPoolTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<String> scheduledFuture = executorService.schedule(new Callable<String>() {
            public String call() throws Exception {
                return "call";
            }
        }, 10, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.get());
        executorService.shutdown();

//        test(true);
    }

    public static boolean test(boolean flag){
        ScheduledFuture futureTask = SchedulerUtils.scheduleFutureTask(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("==============="+Thread.currentThread().getName()+"===============");
                return flag;
            }
        }, 10, TimeUnit.SECONDS);
        return !futureTask.isCancelled();
    }
}
