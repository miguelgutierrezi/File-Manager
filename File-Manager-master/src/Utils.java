import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils {
	
	public static String[][] read_InFile(String file_name) throws FileNotFoundException, IOException, InterruptedException {	
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
		return files;
	}
	
	public static ArrayList<File> generate_Files (String[][] files) throws IOException {
		ArrayList<File> gFiles = new ArrayList<File>();
		ArrayList<String> gLines = new ArrayList<String>();
		Boolean[] marks = new Boolean[8];
		String[] lines = new String[8];
		int c_lines;
		for (int i=0; i<8; i++) {
			File file = new File(files[i][0]);
			gLines = readClientFile(files[i][0]);
			marks = file.getMarks();
			lines = file.getLines();
			marks[Integer.parseInt(files[i][1])-1] = true;
			lines[Integer.parseInt(files[i][1])-1] = gLines.get(Integer.parseInt(files[i][1])-1);
			file.setLines(lines);
			file.setMarks(marks);
			c_lines = file.getCant_lines();
			c_lines++;
			file.setCant_lines(c_lines);
			gFiles.add(file);
		}
		
		return gFiles;
	}
	
	public static void write_Files (ArrayList<File> files) throws IOException {
		String[] lines = new String[8];
		for (File f: files) {
			java.io.File fil = new java.io.File(f.getName() + "Salida.txt");
			lines = f.getLines();
			
			FileWriter writer = new FileWriter(fil);
			
			for (String s: lines) {
				writer.write(s + "\n");
			}
			writer.close();
		}
	}
	
	public static ArrayList<String> readClientFile(String file_Name) throws IOException {
		ArrayList<String> nombres = new ArrayList<String>();
		String chain;
		FileReader f = new FileReader(file_Name);
		BufferedReader b = new BufferedReader(f);
		
		while ((chain = b.readLine()) != null) {
			
			nombres.add(chain);
		}
		b.close();
		
		return nombres;
	}
	
	public static String[] getFiles( String dir_path ) {

        String[] arr_res = null;

        java.io.File f = new java.io.File( dir_path );

        if ( f.isDirectory( )) {

            List<String> res   = new ArrayList<>();
            java.io.File[] arr_content = f.listFiles();

            int size = arr_content.length;

            for ( int i = 0; i < size; i ++ ) {

                if ( arr_content[ i ].isFile( )) {
                	StringTokenizer tokens = new StringTokenizer(arr_content[i].toString(), "\\");
                	String token = null;
        			
        			while (tokens.hasMoreTokens()) {
        				token = tokens.nextToken();
        			}
                	res.add(token);
                }
            }
            arr_res = res.toArray( new String[ 0 ] );
        } else
            System.err.println( "¡ Path NO válido !" );
        return arr_res;
    }
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String s;
		Boolean b = false;
		Scanner scanner = new Scanner(System.in);
		s = scanner.nextLine();
		ArrayList<String> nombres = new ArrayList<String>();
		
		/*write_Files(generate_Files(read_InFile(s)));
		
		nombres = readClientFile("cliente.txt");
		for (String st: nombres) {
			System.out.println(st);
		}*/
		
		String path = "C:/Users/migue/OneDrive/Documentos/GitHub/File-Manager/Cliente1";
        String[] files = getFiles( path );
        if ( files != null ) {
            int size = files.length;
            for ( int i = 0; i < size; i ++ ) {
                System.out.println( files[ i ] );
            }
        }
	}
}