//import scanner
import java.util.Scanner;

class employee{
    private String name;
    private String designation;
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
        System.out.println("Enter Designation");
        String designation = input.nextLine();
        //set the object variables
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;

        System.out.println("Employee Created");
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Salary: " + this.salary);
        System.out.println("Designation: " + this.designation);
    }

    public void raiseSalary(double raise){
        this.salary = this.salary + raise;
        System.out.println("Salary Raised");
    }

};

public class assign{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        employee emp = new employee();
        System.out.println("==================================================\nEmployee Manager\n==================================================");
        //make a flag and run loop while flag is true
        boolean flag = true;
        while(flag){
            //give the option to create an employee, display employee details or quit
            System.out.println("What do you want to do");
            System.out.println("1. Create an Employee");
            System.out.println("2. Display Employee Details");
            System.out.println("3. Raise Salary");
            System.out.println("4. Quit");
            System.out.println("Enter Choice: ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    emp.createEmp();
                    break;
                case 2:
                    emp.display();
                    break;
                case 3:
                    System.out.println("Enter Raise Amount");
                    double raise = input.nextDouble();
                    emp.raiseSalary(raise);
                    break;
                case 4:
                    flag = false;
                    System.out.println("Quiting Now...");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
};