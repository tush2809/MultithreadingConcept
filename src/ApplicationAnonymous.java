public class ApplicationAnonymous {

    //Starting threads using the Thread constructor with anonymous classes

    public static void main(String[] args) {
        Runnable runnable = ()-> {
            for (int i=0;i<=10;i++){
                System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        };
        new Thread(runnable).start();
    }

}
