import java.util.Scanner;

class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 100) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied! Balance cannot fall below $100.");
        }
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking initial balance as input
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        SavingsAccount myAccount = new SavingsAccount(initialBalance);

        while (true) {
            System.out.println("\nChoose an option:\n1.deposit \n2.withdraw \n3.check Balance \n4.exit");
          
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                myAccount.deposit(amount);
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
            } else if (choice == 2) {
                myAccount.withdraw(amount);
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
            } else if (choice == 3) {
                System.out.println("Current Balance: " + myAccount.getBalance());
            } else if (choice == 4) {
                System.out.println("Thank you for using the banking system!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}

