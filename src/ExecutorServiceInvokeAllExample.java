import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceInvokeAllExample {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(5000);
            return "Result of Task3";
        };


          List<Future<String>> futures = executorService.invokeAll(Arrays.asList(task3,task2,task1));

          for(Future<String> future :futures){
              System.out.println(future.get());
          }
          executorService.shutdown();
    }

}
