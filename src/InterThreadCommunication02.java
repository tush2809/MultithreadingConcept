public class InterThreadCommunication02 {

    public static void main(String[] args) throws InterruptedException {

        TotalEarning  totalEarning = new TotalEarning();
        totalEarning.start();
       synchronized (totalEarning){
           System.out.println("Main Thread Is Ready For release the lock*********");
            totalEarning.wait();
        }
        System.out.println(totalEarning.total);

    }
}




 class TotalEarning extends Thread{
    int total=0;
     @Override
     public void run() {
         System.out.println("Get Chance to Child Thread************");
        synchronized (this){
             for (int i = 0; i <=10 ; i++) {
                 total =total+100;
             }
             this.notify();
            System.out.println("Child Thread Notifies to Main Thread*******");
         }
     }
 }