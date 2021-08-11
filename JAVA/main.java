import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        imp.main(name);
    }
};

class imp extends main {
    public static void main(String args) {
        System.out.println("Hello " + args + " from Imported Class");
    }
};
