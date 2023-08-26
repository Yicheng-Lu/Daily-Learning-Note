package ThreadEx;

public class DaemonThread implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName() + " is Running.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Is main thread a daemon thread? " + Thread.currentThread().isDaemon());
        DaemonThread dth = new DaemonThread();
        Thread thread = new Thread(dth, "Daemon Thread");
        System.out.println("Is this thread a daemon thread by default? " + thread.isDaemon());
        thread.setDaemon(true);
        thread.start();

        // main thread task
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
    }
}
