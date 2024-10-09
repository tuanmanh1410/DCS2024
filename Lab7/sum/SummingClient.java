import java.rmi.*;

public class SummingClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SummingClient <host:port> <number>");
            System.exit(1);
        }

        try {
            // Build the RMI URL
            String serverURL = "rmi://" + args[0] + "/SumServer";

            // Lookup the remote object
            Summing s = (Summing) Naming.lookup(serverURL);

            System.out.println("Your Input = " + args[1]);

            // Parse the input to an integer
            int max = Integer.parseInt(args[1]);

            // Call the remote method and display the result
            System.out.println("The sum from 1 to " + max + " is " + s.sum(max));
        } catch (Exception e) {
            System.out.println("Summing Client exception: " + e);
        }
    }
}
