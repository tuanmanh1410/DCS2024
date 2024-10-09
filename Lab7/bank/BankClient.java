import java.rmi.*;

public class BankClient {
    public static void main(String[] args) throws Exception {
        Bank bank = (Bank) Naming.lookup("//localhost/BankIp");
        System.out.println("Bank object retrieved from server");

        // Get the balance
        int balance = bank.getBalance();
        System.out.println("Current balance: " + balance);

        // Deposit 1000
        balance = bank.deposit(1000);
        System.out.println("Deposited 1000\nCurrent balance: " + balance);

        // Withdraw 5000
        balance = bank.withdraw(5000);
        System.out.println("Withdrew 5000\nCurrent balance: " + balance);
    }
}
