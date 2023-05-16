import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.Naming;

public class ServidorRMI extends UnicastRemoteObject implements InterfaceRMI
{
    
    public ServidorRMI() throws RemoteException
	{
		super();
	}
	
    static public void main (String rmi[])
    {
            try 
            {
                    ServidorRMI objetoServidor = new ServidorRMI();
                    System.setProperty("java.rmi.server.hostname", "localhost");
                    LocateRegistry.createRegistry(1099);
                    Naming.bind ("data", objetoServidor);
            } 
            catch (Exception exc) 
            {
                    System.err.println (exc.toString());
            }
    }

    public int fatorial(int num){
            if(num == 1){
                    return 1;
            }
            return fatorial(num - 1)* num;
    }
}