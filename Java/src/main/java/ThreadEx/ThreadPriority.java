package ThreadEx;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + "is printing: " + i);
            }
        }, "Low Priority Thread");

        Thread th2 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + "is printing: " + i);
            }
        }, "High Priority Thread");

        // set priority
        // MIN_PRIORITY 1
        // MAX_PRIORITY 10
        // NORM_PRIORITY 5
        th1.setPriority(Thread.MIN_PRIORITY); // 1
        th2.setPriority(Thread.MAX_PRIORITY); // 10

        th1.start();
        th2.start();
    }
}
