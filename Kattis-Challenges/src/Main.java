import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int x;
		
		for(int i = 0; i < n; i++) {
			x = in.nextInt();
			if(x % 2 == 0) {
				System.out.println(x + " is even");
			}
			else {
				System.out.println(x + " is odd");
			}
		}
		in.close();
		
	} 

}
