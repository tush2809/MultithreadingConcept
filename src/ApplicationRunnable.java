public class ApplicationRunnable {

    public static void main(String[] args) {

         RunnerRunnable runnable = new RunnerRunnable();
         Thread thread = new Thread(runnable);

         RunnerRunnable runnable1 = new RunnerRunnable();
         Thread thread1 = new Thread(runnable1);

         thread1.start();
         thread.start();

    }
}

class RunnerRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<=10;i++){
            System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}