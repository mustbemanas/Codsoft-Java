import java.util.Scanner;

class ATM {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Welcome to the ATM Interface");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public double getAmount(String action) {
        System.out.print("Enter the amount to " + action + ": ");
        return scanner.nextDouble();
    }
}


class BankAccount extends ATM {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
public class task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);
        ATM atm = account;
        boolean exit = false;
        while (!exit) {
            atm.displayMenu();
            int choice = atm.getUserChoice();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    double depositAmount = atm.getAmount("deposit");
                    account.deposit(depositAmount);
                    break;
                case 3:
                    double withdrawAmount = atm.getAmount("withdraw");
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thanks for using our ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}

