import java.util.concurrent.ThreadPoolExecutor;

public class Yield_Method {

    public static void main(String[] args) {
         /*
             Yield method() Cause “to pause current executing Thread for giving the chance
                of remaining waiting Threads of same priority".
        */
       /* YieldMethod one = new YieldMethod();
        YieldMethod two = new YieldMethod();
        one.setName("Thread One");
        two.setName("Thread Two");
        one.start();
        two.start();*/

        PriorityYieldExample highPriority =  new PriorityYieldExample("High Priority", Thread.MAX_PRIORITY);
        PriorityYieldExample lowPriority = new PriorityYieldExample("Low Priority", Thread.MIN_PRIORITY);
        highPriority.setName("Thread1");
        lowPriority.setName("Thread2");
        highPriority.start();
        lowPriority.start();
    }
}

class PriorityYieldExample extends  Thread{

    private int priority;

    public PriorityYieldExample(String name, int priority) {
        super(name);
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            Thread.yield();
        }
    }
}


class  YieldMethod extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            Thread.yield();
        }
    }
}







