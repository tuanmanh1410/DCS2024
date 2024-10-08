import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create the remote object (Hello implementation)
            HelloInterface hello = new Hello();

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object in the registry with the name "HelloService"
            registry.rebind("HelloService", hello);

            System.out.println("RMI server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
