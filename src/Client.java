

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	private Client() {};
	
	public static void main(String[] args) {
		try {
			ServerRmiInterface server = (ServerRmiInterface) Naming.lookup("rmi://localhost/FilesServer");
			ClientInterface client = server.register(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
