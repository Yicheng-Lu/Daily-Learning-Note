package ThreadEx;

public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 6; i++){
            System.out.println(Thread.currentThread().getName() + " enter: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new ThreadJoin(), "Thread-1");
        th1.start();
        for(int j = 0; j < 6; j++){
            System.out.println(Thread.currentThread().getName() + " enter: " + j);
            if(j == 2){
                th1.join();
            }
        }
    }
}
