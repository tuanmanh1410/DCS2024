import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class BankImpl extends UnicastRemoteObject implements Bank {
    private int total;

    // Constructor that throws RemoteException
    public BankImpl(int total) throws RemoteException {
        this.total = total;
    }

    // Implementing the getBalance method
    @Override
    public int getBalance() throws RemoteException {
        return total;
    }

    // Implementing the deposit method
    @Override
    public int deposit(int amount) throws RemoteException {
        total += amount;
        return getBalance();
    }

    // Implementing the withdraw method
    @Override
    public int withdraw(int amount) throws RemoteException {
        total -= amount;
        return getBalance();
    }

    // Main method to start the RMI server
    public static void main(String[] args) {
        try {
            // Create and export a remote object
            BankImpl bank = new BankImpl(10000);

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry with the name "BankIp"
            Naming.rebind("BankIp", bank);

            System.out.println("Bank server is ready and bound with the name BankIp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
