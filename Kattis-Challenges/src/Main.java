import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> initials = new ArrayList<String>();
		String o = "";
		
		String[] names = in.nextLine().split("-");
		for(int i = 0; i < names.length; i++) {
			initials.add(names[i].substring(0, 1));
		}
		in.close();
		
		for(int i = 0; i < initials.size(); i++) {
			o = o + initials.get(i);
		}
		System.out.println(o);
	}

}
