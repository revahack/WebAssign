//make an interface for the main class
interface if1{
    public void m1();
}
//make a class to access the interface
public class inter{
    public static void main(String[] args){
        if1 i = new if1(){
            public void m1(){
                System.out.println("interface method m1");
            }
        };
        i.m1();
    }
}