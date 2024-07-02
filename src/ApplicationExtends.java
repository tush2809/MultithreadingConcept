public class ApplicationExtends {

    public static void main(String[] args) {

    Runner runner = new Runner();
    runner.setName("1st Thread");
    runner.start();

    Runner runner1 = new Runner();
    runner1.setName("2nd Thread");
    runner1.start();


    }
}

class Runner extends Thread{
    volatile int i=0;

    @Override
    public void run() {
        for (i=0;i<=10;i++){
            System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}