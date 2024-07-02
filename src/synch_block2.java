public class synch_block2 {
    public static void main(String[] args) {

        Displays d1 = new Displays();

        Displays d2 = new Displays();

        Displays d3 = new Displays();
        // All threads are executing on different display Objects so we get irregualr o/p
        MyThread2 thread1 = new MyThread2("Sachin", d1);
        MyThread2 thread2 = new MyThread2("Virat", d2);
        MyThread2 thread3 = new MyThread2("Rohit", d3);


        thread2.start();
        thread1.start();
        thread3.start();
    }
}


class MyThread2 extends Thread{
    private Displays d;
    private String name;

    MyThread2(String name,Displays d){
        this.name=name;
        this.d=d;
    }

    @Override
    public void run() {
        try {

                 d.wish(this.name);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Displays{
    public void wish(String name) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Good Afternoon" +" "+ name);
            Thread.sleep(1000);
        }

    }
}

