//import scanner
import java.util.Scanner;

abstract class employee{
    String name;
    int age;
    double salary;
    String designation;

    public employee(){
    }

    public void createEmp(){
        //create a new scanner object
        Scanner input = new Scanner(System.in);
        //take input for name, age and salary
        System.out.println("Enter Name");
        String name = input.next();
        System.out.println("Enter Age");
        int age = input.nextInt();
        //set the object variables
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;

        System.out.println("Employee Created");
    }

    public void display(){
        if(this.name != null){
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Salary: " + this.salary);
            System.out.println("Designation: " + this.designation);
        }
        else{
            System.out.println("No data entered for " + this.designation);
        }
    }

    public void raiseSalary(){
        this.salary = this.salary + 3000;
        System.out.println("Salary Raised");
    }

};

//make a class clerk which inherits from employee
final class clerk extends employee{
    //create a new clerk object
    public clerk(){
        this.designation = "Clerk";
        this.salary = 8000;
    }
}

//make a class manager which inherits from employee
final class manager extends employee{
    //create a new manager object
    public manager(){
        this.designation = "Manager";
        this.salary = 12000;
    }
    //raise salary of manager
    public void raiseSalary(){
        this.salary = this.salary + 5000;
        System.out.println("Salary Raised");
    }
}

//make a class programmer which inherits from employee
final class programmer extends employee{
    //create a new programmer object
    public programmer(){
        this.designation = "Programmer";
        this.salary = 10000;
    }
    //raise salary of programmer
    public void raiseSalary(){
        this.salary = this.salary + 5000;
        System.out.println("Salary Raised");
    }
}

public class assign{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        employee emp = new employee();
        clerk clerk = new clerk();
        manager manager = new manager();
        programmer programmer = new programmer();
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
                    System.out.println("Which type of Employee do you want to add");
                    System.out.println("1. Clerk");
                    System.out.println("2. Manager");
                    System.out.println("3. Programmer");
                    System.out.println("Enter Choice: ");
                    int type1 = input.nextInt();
                    switch(type1){
                        case 1:
                            clerk.createEmp();
                            break;
                        case 2:
                            manager.createEmp();
                            break;
                        case 3:
                            programmer.createEmp();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Whose details you want to see");
                    System.out.println("1. Clerk");
                    System.out.println("2. Manager");
                    System.out.println("3. Programmer");
                    System.out.println("Enter Choice: ");
                    int type2 = input.nextInt();
                    switch(type2){
                        case 1:
                            clerk.display();
                            break;
                        case 2:
                            manager.display();
                            break;
                        case 3:
                            programmer.display();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Which Employee do you want to give a raise");
                    System.out.println("1. Clerk");
                    System.out.println("2. Manager");
                    System.out.println("3. Programmer");
                    System.out.println("Enter Choice: ");
                    int type3 = input.nextInt();
                    switch(type3){
                        case 1:
                            clerk.raiseSalary();
                            break;
                        case 2:
                            manager.raiseSalary();
                            break;
                        case 3:
                            programmer.raiseSalary();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
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