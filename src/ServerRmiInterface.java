import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRmiInterface extends Remote{
	public ClientInterface register (String name) throws RemoteException, UnknownHostException;
	
	public void exampleMethod1() throws RemoteException;
	public int exampleMethod2() throws RemoteException;
}
