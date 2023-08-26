package ThreadEx;

public class ThreadSleep {
    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + " is printing: " + i);
                if(i == 2){
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread th2 = new Thread(() -> {
            for(int j = 0; j < 10; j++){
                System.out.println(Thread.currentThread().getName() + " is printing: " + j);
            }
        });

        th1.start();
        th2.start();
    }
}
