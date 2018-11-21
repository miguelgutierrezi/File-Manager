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
	
	private LinkedList<ClientInterface> users;
	private ArrayList<DnsFiles> files;
	
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
		newClient.setIp(ip);
		newClient.setId(users.size() + 1);
		newClient.populateFiles(newClient.getId());
		users.add(newClient);
		for (String s: newClient.getFiles()) {
			/*DnsFiles fil = new DnsFiles(s);
			fil.addIp(ip);*/
			this.files.add(fil);
			System.out.println(s);
		}
		System.out.println("Nuevo cliente: " + name + " Ip: " + ip + " Id: " + newClient.getId());
		/*for (DnsFiles f: this.files) {
			System.out.println(f.getName());
			for (String s: f.getIps()) {
				System.out.println(s);
			}
		}*/
		return newClient;
	}
}
