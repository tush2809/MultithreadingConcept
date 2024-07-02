public class waiting_of_child_until_complete_main_for_some_time {
    public static void main(String[] args) throws InterruptedException {
        ChildThread.thread=Thread.currentThread();
        ChildThread thread = new ChildThread();
        thread.start();

        ChildThread2 thread1 = new ChildThread2();
        thread1.start();

        System.out.println("main go to sleep --------------------");
        Thread.currentThread().sleep(3000);
        System.out.println("main out of sleep --------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread........");
        }
    }
}


class  ChildThread extends Thread{
    static Thread thread;
    @Override
    public void run() {
        try {
            System.out.println("child wait for main for 1 second --------------------");
           thread.join(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ok child execute -------------------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread........");
        }

    }
}

class ChildThread2 extends Thread{
    ChildThread thread = new ChildThread();
    @Override
    public void run() {
        try {
            System.out.println("super child  wait for child thread for 1 second --------------------");
            thread.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ok Super child execute -------------------");

        for (int i = 0; i < 5; i++) {
            System.out.println("Super Child Thread........");
        }
    }
}