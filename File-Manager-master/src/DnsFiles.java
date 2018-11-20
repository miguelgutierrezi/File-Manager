import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Miguel
 *
 */
public class DnsFiles {
	String name;
	ArrayList<String> ips;
	
	public DnsFiles(String name) {
		super();
		this.name = name;
		this.ips = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}
	
	public void addIp (String ip) {
		this.ips.add(ip);
	}
}
