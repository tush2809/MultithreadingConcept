public class waiting_of_child_until_complete_main {
    static Thread myThreadRef;
    public static void main(String[] args) throws InterruptedException {
        //MyThread myThreadRef is assigned with main Thread reference
        //after this myThreadRef pointing to main Thread Object
        myThreadRef=Thread.currentThread();
        ChildThread1 thread1 = new ChildThread1();
        thread1.start();
          /*below thread1.join() is indicate that main Thread is waiting for child Thread and in child it is also wait for main Thread
           then program is hanged like deadlock
        */
       // thread1.join();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }



    }
}

class ChildThread1 extends  Thread{
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                waiting_of_child_until_complete_main.myThreadRef.join();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Child Thread");
        }
    }

}