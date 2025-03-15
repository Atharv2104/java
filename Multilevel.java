import java.util.Scanner;

class Student {
    protected int rollNo;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void displayRollNo() {
        System.out.println("Roll Number: " + rollNo);
    }
}

class Test extends Student {
    protected double sub1, sub2;

    public void setMarks(double sub1, double sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    public void displayMarks() {
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
    }
}

class Result extends Test {
    public void displayResult() {
        double total = sub1 + sub2;
       
        displayRollNo();
        displayMarks();
        System.out.println("Total Marks: " + total);

        }
}

public class Multilevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Result studentResult = new Result();

        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();
        studentResult.setRollNo(rollNo);

        System.out.print("Enter Marks for Subject 1: ");
        double sub1 = scanner.nextDouble();
        System.out.print("Enter Marks for Subject 2: ");
        double sub2 = scanner.nextDouble();
        studentResult.setMarks(sub1, sub2);

        System.out.println("\nStudent Result:");
        studentResult.displayResult();

        scanner.close();
    }
}

