import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder numbersReversed = new StringBuilder();
		
		String numbers = in.nextLine();
		
		numbersReversed.append(numbers);
		numbersReversed = numbersReversed.reverse();
		
		int a = Integer.parseInt(numbersReversed.substring(4));
		int b = Integer.parseInt(numbersReversed.substring(0, 3));
		
		if(a > b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
		
		
		
		in.close();
		
	} 

}
