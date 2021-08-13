class thread1 implements Runnable {
    public void run() {
        //print name of thread
        System.out.println(Thread.currentThread() + " : " + "I am Thread");
    }
}

public class RunThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new thread1());
        t1.start();

        thread1 t = new thread1();
        Thread t2 = new Thread(t);
        t2.start();

        t1.setName("Thread1");
        t2.setName("Thread2");
    }
}