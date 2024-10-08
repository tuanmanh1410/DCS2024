import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Get the registry running on localhost at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object by the name "HelloService"
            HelloInterface hello = (HelloInterface) registry.lookup("HelloService");

            // Call the remote method and print the result
            String message = hello.sayHello();
            System.out.println("Message from server: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
