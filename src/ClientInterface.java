import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 */

/**
 * @author Miguel
 *
 */
public interface ClientInterface extends Remote {
	public String getName() throws RemoteException;
	
	public String getLocalIp() throws RemoteException;
	
	public void setId(int client_id) throws RemoteException;
	public int getId() throws RemoteException;
	
	public void setDNSIp(String ip) throws RemoteException;
	public void setIp(String ip) throws RemoteException;
}
