package EclipseTry;

import java.util.*;
import java.sql.*;


abstract class employee{
    String name;
    int age;
    double salary;
    String designation;

    public employee(){
    }

    public employee createEmp(){
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

        System.out.println("Employee Created");

        return this;
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Salary: " + this.salary);
        System.out.println("Designation: " + this.designation);
    }

    abstract void raiseSalary();

};

//make a class clerk which inherits from employee
final class clerk extends employee{
    //create a new clerk object
    public clerk(){
        this.designation = "Clerk";
        this.salary = 8000;
    }
    void raiseSalary(){
        this.salary = this.salary + 3000;
        System.out.println("Salary Raised");
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
        //make a list of employees
        ArrayList<employee> list = new ArrayList<employee>();
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
                            clerk newCl = new clerk();
                            newCl.createEmp();
                            //check if object is empty
                            if(newCl.name == null || newCl.age == 0 || newCl.salary == 0){
                                System.out.println("Employee not created, invalid details entered");
                            }else{
                                //iterate thorough list and check if newCl exists in list
                                boolean found = false;
                                for(employee emp : list){
                                    if(emp.name.equals(newCl.name)){
                                        found = true;
                                        System.out.println("Couldn't add, Employee already exists");
                                    }
                                }
                                if(!found){
                                    list.add(newCl);
                                    //insert into database
                                    try{
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","admin@123");
                                        PreparedStatement pstmt = con.prepareStatement("INSERT INTO emp(name,age,salary,designation) VALUES(?,?,?,?)");
                                        pstmt.setString(1, newCl.name);
                                        pstmt.setInt(2, newCl.age);
                                        pstmt.setDouble(3, newCl.salary);
                                        pstmt.setString(4, newCl.designation);
                                        pstmt.executeUpdate();
                                        System.out.println("Employee added");
                                        pstmt.close();
                                    }
                                    catch(Exception e){
                                        System.out.println(e);
                                    }
                                }
                            }
                            break;
                        case 2:
                            manager newMan = new manager();
                            newMan.createEmp();
                            //check if object is empty
                            if(newMan.name == null || newMan.age == 0 || newMan.salary == 0){
                                System.out.println("Employee not created, invalid details entered");
                            }else{
                                //iterate thorough list and check if newCl exsists in list
                                boolean found1 = false;
                                for(employee emp : list){
                                    if(emp.name.equals(newMan.name)){
                                        found1 = true;
                                        System.out.println("Couldn't add, Employee already exists");
                                    }
                                }
                                if(!found1){
                                    list.add(newMan);
                                    //insert into database
                                    try{
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","admin","admin@123");
                                        PreparedStatement pstmt = con.prepareStatement("INSERT INTO emp(name,age,salary,designation) VALUES(?,?,?,?)");
                                        pstmt.setString(1, newMan.name);
                                        pstmt.setInt(2, newMan.age);
                                        pstmt.setDouble(3, newMan.salary);
                                        pstmt.setString(4, newMan.designation);
                                        pstmt.executeUpdate();
                                        System.out.println("Employee added");
                                        pstmt.close();
                                    }
                                    catch(Exception e){
                                        System.out.println(e);
                                    }
                                }
                            }
                            break;
                        case 3:
                            programmer newPro = new programmer();
                            newPro.createEmp();
                            //check if object is empty
                            if(newPro.name == null || newPro.age == 0 || newPro.salary == 0){
                                System.out.println("Employee not created, invalid details entered");
                            }else{
                                //iterate thorough list and check if newCl exists in list
                                boolean found2 = false;
                                for(employee emp : list){
                                    if(emp.name.equals(newPro.name)){
                                        found2 = true;
                                        System.out.println("Couldn't add, Employee already exists");
                                    }
                                }
                                if(!found2){
                                    list.add(newPro);
                                    //insert into database
                                    try{
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","admin","admin@123");
                                        PreparedStatement pstmt = con.prepareStatement("INSERT INTO emp(name,age,salary,designation) VALUES(?,?,?,?)");
                                        pstmt.setString(1, newPro.name);
                                        pstmt.setInt(2, newPro.age);
                                        pstmt.setDouble(3, newPro.salary);
                                        pstmt.setString(4, newPro.designation);
                                        pstmt.executeUpdate();
                                        System.out.println("Employee added");
                                        pstmt.close();
                                    }
                                    catch(Exception e){
                                        System.out.println(e);
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter name of Employee you want to get details of: ");
                    String type2 = input.next();
                    //check if string is empty
                    if(type2.equals("")){
                        System.out.println("Enter a Valid Name");
                    }
                    else{
                        boolean found = false;
                            //select from database
                            try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","admin","admin@123");
                                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM emp WHERE name=?");
                                pstmt.setString(1, type2);
                                ResultSet rs = pstmt.executeQuery();
                                while(rs.next()){
                                    System.out.println("Name: " + rs.getString("name"));
                                    System.out.println("Age: " + rs.getInt("age"));
                                    System.out.println("Salary: " + rs.getDouble("salary"));
                                    System.out.println("Designation: " + rs.getString("designation"));
                                }
                                rs.close();
                                pstmt.close();
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                            found = true;
                        }
                        if(!found){
                            System.out.println("Employee Not Found");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter name of Employee do you want to give a raise: ");
                    String type3 = input.next();
                    //check if string is empty
                    if(type3.equals("")){
                        System.out.println("Enter a Valid Name");
                    }
                    else{
                        boolean found = false;
                            //raise salary in database
                            try{
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","admin","admin@123");
                                PreparedStatement pstmt = con.prepareStatement("UPDATE emp SET salary=? WHERE name=?");
                                pstmt.setDouble(1, emp.salary);
                                pstmt.setString(2, emp.name);
                                pstmt.executeUpdate();
                                pstmt.close();
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                            found = true;
                        }
                        if(!found){
                            System.out.println("Employee Not Found");
                        }
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