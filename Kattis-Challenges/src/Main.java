import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int x = 0;
		int l = 0;
		
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			l = in.nextInt();
			sb.append(l);
			sb = sb.reverse();
			
			int p = Integer.parseInt(sb.toString().substring(0, 1));
			int q = Integer.parseInt(sb.reverse().toString().substring(0, sb.length() - 1));
			
			x = (int) (x + Math.pow((double) q, (double) p));
			
		}
		System.out.println(x);

		
		
		
		
		
		
	
		
	} 

}
