import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Miguel
 *
 */
public class File {
	private String name;
	private Boolean[] marks = new Boolean[8];
	private String[] lines = new String[8];
	private int cant_lines;
	
	public File(String name) {
		super();
		this.name = name;
		for (int i=0; i<8; i++) {
			marks[i] = false;
		}
		
		for (int i=0; i<8; i++) {
			lines[i] = " ";
		}
		
		cant_lines = 0;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean[] getMarks() {
		return marks;
	}
	
	public void setMarks(Boolean[] marks) {
		this.marks = marks;
	}
	
	public String[] getLines() {
		return lines;
	}
	
	public void setLines(String[] lines) {
		this.lines = lines;
	}
	
	public int getCant_lines() {
		return cant_lines;
	}
	
	public void setCant_lines(int cant_lines) {
		this.cant_lines = cant_lines;
	}
}
