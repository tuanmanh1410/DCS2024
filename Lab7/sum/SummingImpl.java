import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class SummingImpl extends UnicastRemoteObject implements Summing {
    // Constructor
    public SummingImpl() throws RemoteException {
        super();
    }

    // Recursive sum method
    public int sum(int max) throws RemoteException {
        if (max <= 0) return 0;
        else return (max + sum(max - 1));
    }

    // Main method to bind the remote object to the RMI registry
    public static void main(String[] args) {
        try {
            // Create and export a remote object
            SummingImpl s = new SummingImpl();

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry with the name "SumServer"
            Naming.rebind("SumServer", s);

            System.out.println("Summing server is ready and bound with the name SumServer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
