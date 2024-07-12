public class ProducerConsumerEg {

    public static void main(String[] args) {

         Company company = new Company();

          ProducerThread  producerThread = new ProducerThread(company);
          ConsumerThread consumerThread= new ConsumerThread(company);
          producerThread.start();
          consumerThread.start();

    }
}

class ProducerThread extends Thread{
    Company cc;
    ProducerThread(Company c){
        this.cc=c;
    }
    @Override
    public void run() {
        int i=1;
        while (true){
            try {
                cc.produce_item(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}

class ConsumerThread extends Thread{
    Company c;
    ConsumerThread(Company c){
        this.c=c;
    }

    @Override
    public void run() {
         while (true){
             try {
                 this.c.consume_item();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             try {
                 Thread.sleep(2000);
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }
         }
    }
}


class Company {
    int n;
    boolean flag=false;
   synchronized public void produce_item(int n) throws InterruptedException {

       if(flag){
           wait();
       }

        this.n=n;
        System.out.println("Produces " + this.n);
        flag=true;
        notify();
    }


    synchronized public int  consume_item() throws InterruptedException {

       if(!flag){
           wait();
       }
        System.out.println("Consumed " + this.n);
       flag=false;
        notify();

        return this.n;
    }
}