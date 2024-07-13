import java.util.concurrent.*;

public class ExecutorFrameworkConcept {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Inside : " + Thread.currentThread().getName());
        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        Runnable task2 = () -> {
            System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }

        };

        Runnable task3 = () -> {
            System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
        };

        System.out.println("Submitting the tasks for execution...");

          executorService.execute(task1);
          executorService.submit(task2);

         executorService.submit(task3);

         executorService.shutdown();
    }
}


