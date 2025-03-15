import java.util.*;
class Factorial{
public static void main(String[]args){
int num;
Scanner scan=new Scanner(System.in);
    System.out.println("enter the No:");
    num=scan.nextInt();
    long factorial = 1;
        
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        
        System.out.println("Factorial of " + num + " is " + factorial);
        
        Scanner.close();
        }
}
        


