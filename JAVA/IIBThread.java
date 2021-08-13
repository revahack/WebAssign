class IIB extends Thread {
    public void run() {
        try {
            //for loop till a is 21
            for (int i = 10; i < 21; i++) {
                IIB(i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Exception in IIBThread");
        }
    }
    static int a;
    {
        a = 1;
    }
    static {
        System.out.println("Static block in IIBThread " + a);
    }
    public void IIB(int i) {
        System.out.println("In IIB " + i);
    }
}
class IIBLoop extends Thread {
    public void run() {
        try {
            //for loop till a is 11
            for (int i = 0; i < 11; i++) {
                System.out.println("I am in IIBLoop : " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Exception in IIBLoop");
        }
    }
}
public class IIBThread{
    public static void main(String[] args){
        IIB iib = new IIB();
        IIBLoop iibl = new IIBLoop();
        IIBLoop iibl2 = new IIBLoop();
        iib.start();
        iibl.start();
        iibl2.start();

        iib.setName("Thread 1");
        iibl.setName("Thread 2");
        iibl2.setName("Thread 3");

        iibl2.setPriority(Thread.MAX_PRIORITY);

    }
}