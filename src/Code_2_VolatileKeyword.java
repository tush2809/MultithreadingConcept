import java.util.Scanner;

public class Code_2_VolatileKeyword {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
        new Scanner(System.in).nextLine();
        processor.shutdown();
    }
}

class Processor extends Thread{
    private boolean running=true;
    @Override
    public void run() {
        while(running) {
            System.out.println("Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void shutdown(){
        running=false;
    }
}