import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsPeriodicExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(1);

        Runnable runnable = ()->{
            System.out.println("Executing Task At " + new Date().getSeconds());
        };

        System.out.println("scheduling task to be executed every 2 seconds with an initial delay of 0 seconds");
        executorService.scheduleAtFixedRate(runnable,0,2, TimeUnit.SECONDS);
    }
}
