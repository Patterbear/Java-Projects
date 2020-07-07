import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		HashMap<String, Integer> domValues = new HashMap<String, Integer>();
		
		domValues.put("A", 11);
		domValues.put("K", 4);
		domValues.put("Q", 3);
		domValues.put("J", 20);
		domValues.put("T", 10);
		domValues.put("9", 14);
		domValues.put("8", 0);
		domValues.put("7", 0);
		
		HashMap<String, Integer> values = new HashMap<String, Integer>();
		
		values.put("A", 11);
		values.put("K", 4);
		values.put("Q", 3);
		values.put("J", 2);
		values.put("T", 10);
		values.put("9", 0);
		values.put("8", 0);
		values.put("7", 0);
		
		Scanner in = new Scanner(System.in);
		String nb = in.nextLine();
		
		String[] nbArray = nb.split(" ", 2);
		
		int t = 0;
		int n = Integer.parseInt(nbArray[0]);
		String b = nbArray[1];
		String c;
		String v;
		String s;
		
		
		for(int i = 0; i <  n * 4; i++) {
			c = in.nextLine();
			v = c.substring(0, 1);
			s = c.substring(1);
			
			if (s.equals(b)) {
				t = t + domValues.get(v);
			}
			else {
				t = t + values.get(v);
			}
		}
		System.out.println(t);
		
		
	}

}
