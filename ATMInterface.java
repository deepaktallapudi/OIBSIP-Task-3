import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date) + ": " + type + " of $" + amount;
    }
}

class BankAccount {
    private String userId;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String userId, double initialBalance) {
        this.userId = userId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        }
        return false;
    }

    public boolean transfer(double amount, BankAccount recipient) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Transfer to " + recipient.getUserId(), amount));
            recipient.deposit(amount);
            recipient.transactionHistory.add(new Transaction("Transfer from " + userId, amount));
            return true;
        }
        return false;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for client User ID: " + userId);
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(String userId, double initialBalance) {
        account = new BankAccount(userId, initialBalance);
    }

    public void displayOptions() {
        System.out.println("ATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Inadequate balance. Withdrawal failed.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public void transfer(double amount, ATM recipientATM) {
        if (account.transfer(amount, recipientATM.account)) {
            System.out.println("Transfer successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Inadequate balance. Transfer failed.");
        }
    }

    public void displayTransactionHistory() {
        account.displayTransactionHistory();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter client User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        ATM atm = new ATM(userId, initialBalance);

        int choice;
        do {
            atm.displayOptions();
            System.out.print("Enter your choice from (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter recipient's User ID: ");
                    String recipientUserId = scanner.nextLine();
                    ATM recipientATM = new ATM(recipientUserId, 0);
                    atm.transfer(transferAmount, recipientATM);
                    break;

                case 5:
                    atm.displayTransactionHistory();
                    break;

                case 6:
                    System.out.println("Thankyou And Visit Again");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
