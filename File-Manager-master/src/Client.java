

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	private Client() {};
	
	public static void main(String[] args) {
		try {
			ServerRmiInterface server = (ServerRmiInterface) Naming.lookup("rmi://" + "10.192.230.23" + "/FilesServer");
			ClientInterface client = server.register(args[0], InetAddress.getLocalHost().getHostAddress());
			System.out.println("Ip cliente: " + InetAddress.getLocalHost().getHostAddress());
			System.out.println(client.getId());
			
			/*while (true) {
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
