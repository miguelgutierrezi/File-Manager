

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Naming.rebind("FilesServer", new FilesServerImpl());
			System.out.println("Server is Ready, Listening for Clients");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
