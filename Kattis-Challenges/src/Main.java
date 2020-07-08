import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double q;
		double y;
		double t = 0;
		
		int n = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < n; i++) {
			String[] qy = in.nextLine().split(" ", 2);
			q = Double.parseDouble(qy[0]);
			y = Double.parseDouble(qy[1]);
			t = t + q *y;
		}
		System.out.println(t);
	}

}
