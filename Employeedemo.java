class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public double calculateBonus() {
        return salary * 0.10; // Default 10% bonus
    }

    public void generatePerformanceReport() {
        System.out.println("Performance Report for: " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }
}

class Manager extends Employee {
    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // 20% bonus for managers
    }

    public void manageProject() {
        System.out.println(name + " is managing a project.");
    }
}

class Developer extends Employee {
    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15; // 15% bonus for developers
    }

    public void writeCode() {
        System.out.println(name + " is writing code.");
    }
}

class Programmer extends Employee {
    public Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.12; // 12% bonus for programmers
    }

    public void debugCode() {
        System.out.println(name + " is debugging code.");
    }
}

public class Employeedemo {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", "123 Street, City", 80000);
        Developer developer = new Developer("Bob", "456 Avenue, City", 60000);
        Programmer programmer = new Programmer("Charlie", "789 Road, City", 50000);

        manager.generatePerformanceReport();
        manager.manageProject();

        System.out.println();

        developer.generatePerformanceReport();
        developer.writeCode();

        System.out.println();

        programmer.generatePerformanceReport();
        programmer.debugCode();
    }
}

