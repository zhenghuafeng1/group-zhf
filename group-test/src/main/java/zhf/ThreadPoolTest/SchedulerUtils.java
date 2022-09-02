package zhf.ThreadPoolTest;

import java.util.concurrent.*;

public class SchedulerUtils {
    private  static ScheduledExecutorService scheduledThreadPool =
            Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()*5);

    public static ScheduledExecutorService getScheduledThreadPool() {
        return scheduledThreadPool;
    }

    public static <V> ScheduledFuture scheduleFutureTask(Callable<V> callable, long delay, TimeUnit unit){
        FutureTask<V> futureTask = new FutureTask<V>(callable);
        return getScheduledThreadPool().schedule(futureTask, delay, unit);
    }
}
