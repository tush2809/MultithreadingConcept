import java.util.concurrent.*;

public class FutureAndCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable callable = () -> {
            System.out.println("Entered In Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        Future<String> future = executorService.submit(callable);
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();


    }
}
