package ThreadEx;

public class RunnableFunc implements Runnable{
    @Override
    public void run(){
        int i = 0;
        while (i++ < 5){
            System.out.println(Thread.currentThread().getName() + " override run() function of Runnable interface " + i);
        }
    }

    public static void main(String[] args) {
        // Override run() of Runnable Interface
        RunnableFunc th = new RunnableFunc();
        Thread thread1 = new Thread(th, "Thread1");
        thread1.start();
        Thread thread2 = new Thread(th, "Thread2");
        thread2.start();
    }
}
