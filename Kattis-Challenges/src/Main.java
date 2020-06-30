import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int n = in.nextInt();
		int p = 0;
		int r = 0;
		
		for(int i = 0; i < n; i++) {
			p = in.nextInt();
			r = r + x - p;
		}
		System.out.println((r + x));
		
	}

}
