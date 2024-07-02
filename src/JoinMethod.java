public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        /**
         *Here main thread is waiting for Thread2 to execute by calling t2.join() and thread2 is waiting
         for Thread1 to execute by calling t_hold_1.join() as t_hold_1 refer Thread1
         so 1st Thread1 execute and then Thread2 and then main
         */
          Thread1 thread1 = new Thread1();
          thread1.start();
          //Thread2.t_thread_1=thread1;
          Thread2 thread2=new Thread2();
          thread2.start();
          thread2.join();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread 1");
        }
    }
}

class  Thread2 extends Thread{
     Thread1 t_thread_1 = new Thread1();
    @Override
    public void run() {
        try {
           t_thread_1.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i <5; i++) {
            System.out.println("Thread 2");
        }
    }
}

