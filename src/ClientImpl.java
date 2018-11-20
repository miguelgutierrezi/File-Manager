import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 */

/**
 * @author Miguel
 *
 */
public class ClientImpl extends UnicastRemoteObject implements ClientInterface{
	
	private String name;
	private int user_id;
	private String ip;
	private String DNSIp;
	
	public ClientImpl(String name, String DNSIp) throws RemoteException, UnknownHostException {
		this.name = name;
		this.ip = InetAddress.getLocalHost().getHostAddress();
		this.DNSIp = DNSIp;
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public String getLocalIp() throws RemoteException {
		return this.ip;
	}

	@Override
	public void setId(int client_id) throws RemoteException {
		this.user_id = client_id;
	}

	@Override
	public int getId() throws RemoteException {
		return this.user_id;
	}

	@Override
	public void setDNSIp(String ip) throws RemoteException {
		this.DNSIp = ip;
	}

}
