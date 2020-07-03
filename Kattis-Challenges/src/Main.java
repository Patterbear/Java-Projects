import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String values = in.nextLine();
		in.close();
		
		String[] valuesArray = values.split(" ", 2);
		
		double a = Integer.parseInt(valuesArray[0]);
		double i = Integer.parseInt(valuesArray[1]);
		double t = i;
		double c = a * i;
		
		for(int j = 0; i > t - 1; j++) {
			c = c - 1;
			i = c / a;
		}
		System.out.println((int)c + 1);
		
		
		
		
	
		
	} 

}
