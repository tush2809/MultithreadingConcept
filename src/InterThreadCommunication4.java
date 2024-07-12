public class InterThreadCommunication4 {

    public static void main(String[] args) throws InterruptedException {

        TotalCalculation totalCalculation = new TotalCalculation();
        totalCalculation.start();
        System.out.println("Main Thread going to slip..........");
        Thread.sleep(1000);
        System.out.println("Main Thread out from to slip..........");

        synchronized (totalCalculation){
            System.out.println("Main thread going to wait stage..........");
            totalCalculation.wait(1000);
            System.out.println("Main thread out from to wait stage..........");
            System.out.println(totalCalculation.total);
        }

    }
}

class TotalCalculation extends Thread{
     int total=0;
    @Override
    public void run() {
        System.out.println("Calling child thread.......");
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                total +=i;
            }
            System.out.println("Child thread notifies to main thread.....");
            this.notify();
        }
    }
}