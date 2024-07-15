
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceInvokeAnyExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService  executorService= Executors.newSingleThreadExecutor();

        Callable<String> task1 = ()-> {
            Thread.sleep(2000);
            return "result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "result of Task2";
        };

        Callable<String> task3 = ()->{
            Thread.sleep(5000);
            return "result of Task3";
        };

         String result = executorService.invokeAny(Arrays.asList(task3,task2,task1));
        System.out.println(result);

        executorService.shutdown();

    }
}
