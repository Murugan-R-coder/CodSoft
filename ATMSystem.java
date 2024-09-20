import java.util.*;
class BankAccount {
    private String accountHolder;
    private double balance;
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit successful. New balance: " + balance;
        } else {
            return "Invalid amount. Deposit must be greater than 0.";
        }
    }
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient balance. Current balance: " + balance;
        } else if (amount <= 0) {
            return "Invalid amount. Withdrawal must be greater than 0.";
        } else {
            balance -= amount;
            return "Withdrawal successful. New balance: " + balance;
        }
    }
    public double checkBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void displayMenu() {
        int option = 0;
        do {
            System.out.println("\nWelcome, " + account.getAccountHolder());
            System.out.println("ATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        String message = account.deposit(amount);
        System.out.println(message);
    }
    private void handleWithdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        String message = account.withdraw(amount);
        System.out.println(message);
    }
    private void handleCheckBalance() {
        System.out.println("Your current balance is: " + account.checkBalance());
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Murugan", 1000.0);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}
