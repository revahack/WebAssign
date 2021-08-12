package package1;

class A{
    static int y=100;
    public static void disp(){
        System.out.println(y);
    }
}

public class package1 {
    public static void main(String args) {
        System.out.println("Hi " + args + " ! From a Package!!\n\n");
        A a = new A();
        System.out.println(a.y);
        a.y=200;
        System.out.println(a.y);
        A.disp();
    }
}
