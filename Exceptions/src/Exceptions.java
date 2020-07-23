import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Exceptions {

	public static void main(String[] args) {
		
		//Throws NumberFormatException as the value cannot be parsed
		int number = Integer.parseInt("string");
		
		//ArrayList 'x' created
		ArrayList<Integer> x = new ArrayList<Integer>();
		
		//Throws IndexOutOfBoundsException as the specified index does not exist
		x.get(5);
		
		//Throws FileNotFoundException as the specified file does not exist
		FileInputStream f = new FileInputStream("missing.txt");
	}
	
	//Method declared with 'throws' declaration
	static void doSomething() throws FileNotFoundException {
			FileInputStream f = new FileInputStream("missing.txt");
	}
	
	static void doSomethingElse() {
		
		//Statement surrounded by try/catch to deal with the exception within the method
		try {
			FileInputStream f = new FileInputStream("missing.txt");
		} catch (FileNotFoundException e) {
			//StackTrace is output to console
			e.printStackTrace();
		}
	}

}
