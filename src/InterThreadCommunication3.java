public class InterThreadCommunication3 {
    public static void main(String[] args) throws InterruptedException {

        TotalExpenditure expenditure = new TotalExpenditure();
        expenditure.start();
        System.out.println("Main Thread Going to slip...........");
        Thread.sleep(2000);
        System.out.println("Main Thread is out from slip...........");
        synchronized (expenditure){
            System.out.println("Main Thread is going to wait...............");
            expenditure.wait(1000);
            System.out.println("Main Thread notifies...............");//not execute
            System.out.println(expenditure.total);//not execute
        }


    }
}

//Run this code and see o/p and also analyse
//most of time main thread get chance according to that flow indicated by numbers
/*
  As main thread get chance but main sleep for 10 sec then child start
  calculation after child send notification after that main thread is waiting
  so we get o/p as
  child thread start calculation
  Child thread trying to give
  notification main thread trying to call wait method
AND program is stucked here only
  */

class TotalExpenditure extends Thread{
    int total=0;

    @Override
    public void run() {
       synchronized (this){
           System.out.println("Child Thread execution start........");
           for (int i = 0; i <=100; i++) {
               total +=i;
           }
           this.notify();
           System.out.println("Child Thread notifies to main thread ........");
       }
    }
}

