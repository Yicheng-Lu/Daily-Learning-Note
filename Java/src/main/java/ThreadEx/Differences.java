package ThreadEx;

public class Differences extends Thread{
//    // Thread will deal with resources independently
//
//    private int ticket = 100;
//    public void run(){
//        while(ticket > 0){
//            System.out.println(Thread.currentThread().getName() + " is selling No." + ticket-- + " ticket.");
//        }
//    }
//
//    public static void main(String[] args) {
//        new ThreadDifference().start();
//        new ThreadDifference().start();
//        new ThreadDifference().start();
//        new ThreadDifference().start();
//    }

    // Using Runnable interface will allow all the threads share the same resources
    private int ticket = 100;

    @Override
    public void run() {
        while(ticket > 0){
            System.out.println(Thread.currentThread().getName() + " is selling No." + ticket-- + " ticket.");
        }
    }

    public static void main(String[] args) {
        Differences tw = new Differences();
        new Thread(tw, "Ticket Window No.1").start();
        new Thread(tw, "Ticket Window No.2").start();
        new Thread(tw, "Ticket Window No.3").start();
        new Thread(tw, "Ticket Window No.3").start();
    }
}
