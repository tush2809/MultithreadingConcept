public class synch_block3_class_level_lock {


    public static void main(String[] args) {


        Displays2 d1 = new Displays2();

        Displays2 d2 = new Displays2();

        Displays2 d3 = new Displays2();

        // on same display Object both threads are exeucting
        //even though both threads are executing different display objects but they need class level lock to execute so here at a time one
        //thread exexute i.e. if one thread get class level lock then other thread has to wait until complete of synchronized block code of  that thread
        MyThread3 thread1 = new MyThread3("Sachin", d1);
        MyThread3 thread2 = new MyThread3("Virat", d2);
        MyThread3 thread3 = new MyThread3("Rohit", d3);


        thread2.start();
        thread1.start();
        thread3.start();
    }
}

class MyThread3 extends Thread{
    private Displays2 d;
    private String name;

    MyThread3(String name,Displays2 d){
        this.name=name;
        this.d=d;
    }

    @Override
    public void run() {

        try {
            //consider here 1 lakh line of code which can be executed by mutliple threads simaltaneously
            ;;;;;;;;;;;;;;;;;
            System.out.println("before synchronized block");
            //if very few lines of code required synchronization then we should declare that code inside synchronizaion block
          synchronized (Displays2.class){
              d.wish(this.name);
          }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        // consider here 1 lakh line of code which can be executed by mutliple threads simaltaneously
    }
}

class Displays2{
    public void wish(String name) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Good Afternoon" +" "+ name);
            Thread.sleep(1000);
        }

        System.out.println("After synchronized block");

    }
}
