package ThreadEx;

public class ThreadYield extends Thread{
    public ThreadYield(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "---" + i);
            if(i == 2){
                System.out.println("Thread Yield");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        ThreadYield th1 = new ThreadYield("Thread 1");
        ThreadYield th2 = new ThreadYield("Thread 2");

        th1.start();
        th2.start();
    }
}
