import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> mostLikely = new ArrayList<Integer>();
		Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
		Scanner in = new Scanner(System.in);
		
		String faces = in.nextLine();
		in.close();
		
		String[] facesArray = faces.split(" ", 2);

		int n = Integer.parseInt(facesArray[0]);
		int m = Integer.parseInt(facesArray[1]);
		int max = n + m;
		
		for(int i = 0; max > 1; i++) {
			dic.put(max, 0);
			max = max - 1;
		}
		
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < m + 1; j++) {
				int k = i + j;
				dic.put(k, dic.get(k) + 1);
			}
		}
		
		mostLikely.add(0);
		int o = 0;
		
		for(int i = 2; i < dic.size(); i ++) {
			if (dic.get(i) > o) {
				o = dic.get(i);
				mostLikely.clear();
				mostLikely.add(i);
			}
			else if(dic.get(i) == o) {
				mostLikely.add(i);
			}
			
		}
		
		for(int i = 0; i < mostLikely.size(); i++) {
			System.out.println(mostLikely.get(i));
		}
	}

}
