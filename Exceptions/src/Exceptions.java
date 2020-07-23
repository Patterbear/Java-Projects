import java.io.IOException;

public class Exceptions {

	public static void main(String[] args) {
		
		//Object 'exceptions' created from class 'Exceptions'
		Exceptions exceptions = new Exceptions();
		
		//'doSomething' method called
		exceptions.doSomething();
		
	}
	
	void doSomething() {
		try {
			//IOException thrown
			throw new IOException();
		} catch (IOException | IndexOutOfBoundsException e) {
			//Text is outputted in the console
			System.out.println("More specific");
		} catch (Exception e) {
			//Text is outputted in the console
			System.out.println("Caught you!");
			
			//StackTrace is outputted in the console
			e.printStackTrace();
		}
	}
	
}
