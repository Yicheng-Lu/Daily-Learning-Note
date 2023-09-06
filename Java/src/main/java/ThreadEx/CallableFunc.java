package ThreadEx;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFunc implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        while(i++ < 5){
            System.out.println(Thread.currentThread().getName() + " override call() function of Callable interface " + i);
        }
        return i;
    }

    public static void main(String[] args){
        // Override call() of Callable Interface
        CallableFunc th = new CallableFunc();
        FutureTask<Integer> ft1 = new FutureTask<>(th);
        Thread th1 = new Thread(ft1, "Thread1");
        th1.start();

        FutureTask<Integer> ft2 = new FutureTask<>(th);
        Thread th2 = new Thread(ft2, "Thread2");
        th2.start();
    }
}
