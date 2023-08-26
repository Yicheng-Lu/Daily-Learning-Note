package ThreadEx;

public class InheritThreadClass extends Thread{
    public InheritThreadClass(String name){
        super(name);
    }

    public void run(){
        int i = 0;
        while (i++ < 5){
            System.out.println(Thread.currentThread().getName()+ " inherit directly from Thread Class" + i);
        }
    }

    public static void main(String[] args) {
        // Inherit from Thread Class
        InheritThreadClass th1 = new InheritThreadClass("Thread1");
        th1.start();
        InheritThreadClass th2 = new InheritThreadClass("Thread2");
        th2.start();
    }
}
