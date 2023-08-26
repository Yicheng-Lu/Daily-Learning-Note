package ThreadEx;

public class ThreadSynchronize implements Runnable{
    @Override
    public void run() {

    }
//    // May cause error if the threads are not synchronized
//    private int ticket = 10;
//
//    @Override
//    public void run() {
//        while(true){
//            if(ticket > 0){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " is selling No." + ticket-- + " ticket.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        ThreadSynchronize th1 = new ThreadSynchronize();
//
//        new Thread(th1, "Ticket Window 1").start();
//        new Thread(th1, "Ticket Window 2").start();
//        new Thread(th1, "Ticket Window 3").start();
//        new Thread(th1, "Ticket Window 4").start();
//    }
    private
}
