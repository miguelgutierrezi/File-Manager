import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
	String[] files;
	
	public ClientImpl(String name, String ip) throws RemoteException, UnknownHostException {
		this.name = name;
		this.ip = ip;
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

	@Override
	public void setIp(String ip) throws RemoteException {
		// TODO Auto-generated method stub
		this.ip = ip;
	}

	@Override
	public void populateFiles(int user_id) throws RemoteException {
		// TODO Auto-generated method stub
		if (user_id == 1) {
			String path = "C:/Users/sala a/Downloads/File-Manager-master/Cliente1";
			files = Utils.getFiles(path);
		} else if (user_id == 2) {
			String path = "C:/Users/sala a/Downloads/File-Manager-master/Cliente2";
			files = Utils.getFiles(path);
		} else if (user_id == 3) {
			String path = "C:/Users/sala a/Downloads/File-Manager-master/Cliente3";
			files = Utils.getFiles(path);
		}
	}

	@Override
	public String[] getFiles() throws RemoteException {
		// TODO Auto-generated method stub
		return this.files;
	}
}
