import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote
{
	public int fatorial(int num) throws RemoteException;
}
