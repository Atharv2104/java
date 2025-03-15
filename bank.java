import java.util.*;
 class bankaccount{
    public  double balance;
    public bankaccount(double initialbalance){
        this.balance=initialbalance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            
                System.out.println("Deposited: " + amount+ "balance: "+balance );
            } else {
                System.out.println("Invalid deposit amount.");
            
        }
    }
    public void withdraw(double amount){
        if(amount>0 && balance>amount){
            balance-=amount;
            System.out.println("withdraw:" +amount +"total balance:"+balance);
        }
        else{
            System.out.println("Invalid amount or insufficient balance.");

               
        }

    }
    public double displaybalance(){
        return balance;
    }
}
class Savingaccount extends bankaccount{
    public Savingaccount(double initialbalance){
        super(initialbalance);
    }
    @Override
    public void withdraw(double amount){
        if(balance -amount>=500){
            balance-=amount;
            System.out.println("withdraw:" +amount +"total balance:"+balance);
         }
         else{
            System.out.println("minimum balance in the bank should be 500rs");
            

         }
    }
}
public class bank{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("enter initial balance :");
        double initialbalance=scan.nextDouble();
        Savingaccount sa=new Savingaccount(initialbalance);
        int choice;
        while (true) {
            System.out.println("\nChoose an option:\n1.deposit \n2.withdraw \n3.check Balance \n4.exit");
          
            System.out.print("Enter your choice: ");
             choice = scan.nextInt();

            if (choice == 1) {
                
                System.out.print("Enter deposit amount: ");
                double amount = scan.nextDouble();
                sa.deposit( amount);
            } else if (choice == 2) {
                
                System.out.print("Enter withdrawal amount: ");
                double amount = scan.nextDouble();
                sa.withdraw(amount);
            } else if (choice == 3) {
                System.out.println("Current Balance: " + sa.displaybalance());
            } else if (choice == 4) {
                System.out.println("Thank you for using the banking system!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scan.close();
}
}


