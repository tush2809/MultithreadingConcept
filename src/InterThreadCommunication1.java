public class InterThreadCommunication1 {
    public static void main(String[] args) throws Exception {
     ThreadA threadA = new ThreadA();
     threadA.start();

     synchronized (threadA){
         System.out.println("main thread trying to call wait method");
         threadA.wait();
         System.out.println("main thread got notificaion ");
         System.out.println(threadA.tot);
     }
    }
}

class ThreadA extends Thread{
  int tot=0;
        @Override
        public void run() {
           synchronized (this){
               System.out.println("child thread start calculation");
               for (int i = 0; i < 100; i++) {
                   tot += i ;
               }
               System.out.println("Child thread trying to give notification");
               this.notify();
           }


    }
}