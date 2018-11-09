package co.edu.javeriana;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Utils {
	
	public static void read_InFile(String file_name) throws FileNotFoundException, IOException, InterruptedException {	
		String chain;
		FileReader f = new FileReader(file_name);
		BufferedReader b = new BufferedReader(f);
		
		while ((chain = b.readLine()) != null) {
			
			StringTokenizer tokens = new StringTokenizer(chain, "-");
			int a = 0;
			String token;
			
			while (tokens.hasMoreTokens()) {
				a++;
				token = tokens.nextToken();
				System.out.println(token);
			}
		}
		b.close();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		read_InFile("prueba.txt");
	}
}