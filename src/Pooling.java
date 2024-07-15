import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Pooling {
    private static final int NUMBER_OF_THREAD=3;
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
        for (int i = 0; i < 10; i++) {
            service.execute(new CreateWorkItemWithOrderNumber(i));
        }
      service.shutdown();
    }


}


class CreateWorkItemWithOrderNumber implements Runnable{
    static final AtomicInteger concurrentExecutions = new AtomicInteger(0);
    int orderNumber;
    public CreateWorkItemWithOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    @Override
    public void run() {
        int numberOfConcurrentExecutions = concurrentExecutions.incrementAndGet();
        System.out.println(MessageFormat.format("This is the {0}th work item running in thread {1}, # of concurrent executions {2}",
                this.orderNumber, Thread.currentThread().getName(), numberOfConcurrentExecutions));
        concurrentExecutions.decrementAndGet();
    }
}





