//import scanner
import java.util.Scanner;

class employee{
    private String name;
    private int age;
    private double salary;

    public employee(){
    }

    public void createEmp(){
        //create a new scanner object
        Scanner input = new Scanner(System.in);
        //take input for name, age and salary
        System.out.println("Enter Name");
        String name = input.nextLine();
        System.out.println("Enter Age");
        int age = input.nextInt();
        System.out.println("Enter Salary");
        double salary = input.nextDouble();
        //set the object variables
        this.name = name;
        this.age = age;
        this.salary = salary;

        System.out.println("Employee Created");
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Salary: " + this.salary);
    }

    public void raiseSalary(double raise){
        this.salary = this.salary + raise;
        System.out.println("Salary Raised");
    }

};

public class basicAss{
    public static void main(String[] args){
        employee emp = new employee();
        emp.createEmp();
        emp.display();
        emp.raiseSalary(10000.00);
        emp.display();
    }
};