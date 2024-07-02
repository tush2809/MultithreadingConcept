public class synch_block1 {
    public static void main(String[] args) {

        Display display = new Display();

        //on same display Object both threads are exeucting

        MyThread thread = new MyThread("Dhoni",display);
        MyThread thread1 = new MyThread("Yuvraj",display);

        thread.start();
        thread1.start();
    }
}


class MyThread extends Thread{
    final Display a;
    String name;
    MyThread(String name, Display a){
        this.name=name;
        this.a=a;
    }

    @Override
    public void run() {
        try {
            synchronized (this.a){
                a.message(this.name);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Display {



    public void message(String name) throws InterruptedException {

        //consider here 1 lakh line of code which can be executed by mutliple threads simaltaneously
        ;;;;;;;;;;;;;;;;;
        //if very few lines of code required synchronization then we should declare that code inside synchronizaion block

        for (int i = 0; i < 5; i++) {
            System.out.println("Good Morning" + " " + name);
            Thread.sleep(1000);
        }

        ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        // consider here 1 lakh line of code which can be executed by mutliple threads simaltaneously

    }
}