/**
 * 
 */


import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Miguel
 *
 */
public class FilesServerImpl extends UnicastRemoteObject implements ServerRmiInterface{
	
	private String ipDNS;
	private LinkedList<ClientInterface> users;
	
	public FilesServerImpl() throws RemoteException {
		users = new LinkedList<>();
	}
	
	@Override
	public void exampleMethod1() throws RemoteException {
		System.out.println("Metodo 1");
	}

	@Override
	public int exampleMethod2() throws RemoteException {
		return 4;
	}

	@Override
	public synchronized ClientInterface register(String name, String ip) throws RemoteException, UnknownHostException {
		ClientInterface newClient = new ClientImpl(name, ip);
		newClient.setId(users.size() + 1);
		users.add(newClient);
		System.out.println("Nuevo cliente: " + name + " Ip: " + newClient.getLocalIp());
		return newClient;
	}
	
	@Override
	public String getDNSIp () {
		return this.ipDNS;
	}
}
