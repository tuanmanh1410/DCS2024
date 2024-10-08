import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// The implementation of the remote interface
public class Hello extends UnicastRemoteObject implements HelloInterface {
    
    // Constructor that throws RemoteException
    public Hello() throws RemoteException {
        super();
    }

    // The implementation of the remote method
    @Override
    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}
