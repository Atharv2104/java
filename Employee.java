import java.util.*;

public class Employee{

    Scanner scan = new Scanner(System.in);
        
        String fname, lname;
        double salary;
        Employee(){
            System.out.println("Employee no argument constructor initialized...");
            fname = " ";
            lname = " ";
            salary = 0;
        }

        //getter
        public String getFname(){
            System.out.println("This is fname getter method");
            return fname;
        }

        public String getLname(){
            System.out.println("This is lname getter method");
            return lname;
        }

        public int getSalary(){
            System.out.println("This is salary getter method");
            if(salary  < 0){
                salary = 0;
            }
            return (int)salary;
        }

        //setter
        public void setfname(){
            System.out.println("Enter first name : ");
            this.fname = scan.nextLine();
        
        }
        public void setlname(){
            System.out.println("Enter last name");
            this.lname = scan.nextLine();

        }
        public void setsalary(){ 
            System.out.println("Enter salary");
            this.salary = scan.nextInt();

        }

        public void displayEmployeeInfo() {
        System.out.println("\nEmployee Details:");
        System.out.println("First Name: " + getFname());
        System.out.println("Last Name: " + getLname());
        System.out.println("Salary: " + getSalary());
    }

        public void employeetest(){
            this.ob1 = 
        }
    
    public static void main(String[] args) {
        
        
        Employee e = new Employee();
        Employee ob1 = new Employee();
        Employee ob2 = new Employee();
        e.setfname();
        e.setlname();
        e.setsalary();
        e.displayEmployeeInfo();
       

    }
}