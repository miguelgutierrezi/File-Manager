package co.edu.javeriana.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Utils {
	
	public static void read_InFile(String file_name) throws FileNotFoundException, IOException, InterruptedException {	
		String[][] files = new String[8][2];
		String chain;
		int fila = 0;
		FileReader f = new FileReader(file_name);
		BufferedReader b = new BufferedReader(f);
		
		while ((chain = b.readLine()) != null) {
			
			StringTokenizer tokens = new StringTokenizer(chain, "-");
			int a = 0;
			String token;
			
			while (tokens.hasMoreTokens()) {
				if (a==0) {
					token = tokens.nextToken();
					files[fila][a] = token;
					a = 1;
				}
				if (a==1) {
					token = tokens.nextToken();
					files[fila][a] = token;
					fila++;
					a = 0;
				}
			}
		}
		b.close();
		generate_Files(files);
	}
	
	public static void generate_Files (String[][] files) {
		ArrayList<File> gFiles = new ArrayList<File>();
		Boolean[] marks = new Boolean[8];
		String[] lines = new String[8];
		int c_lines;
		for (int i=0; i<8; i++) {
			File file = new File(files[i][0]);
			marks = file.getMarks();
			lines = file.getLines();
			marks[Integer.parseInt(files[i][1])-1] = true;
			lines[Integer.parseInt(files[i][1])-1] = files[i][0] + " linea " + files[i][1];
			file.setLines(lines);
			file.setMarks(marks);
			c_lines = file.getCant_lines();
			c_lines++;
			file.setCant_lines(c_lines);
			gFiles.add(file);
		}
		for (File f: gFiles) {
			System.out.println(f.getName());
			for (Boolean b: f.getMarks()) {
				System.out.println(b);
			}
			System.out.println(f.getCant_lines());
			for (String s: f.getLines()) {
				System.out.println(s);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		read_InFile("prueba.txt");
	}
}