import java.util.HashMap;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		
		//Hashmap created with String and Integer data types
		HashMap<String, Integer> ids = new HashMap<String, Integer>();
		
		//Values added to HashMap
		ids.put("Benjamin McGregor", 5);
		ids.put("Adam McGregor", ids.getOrDefault("Adam McGregor", 0) + 1);
		
		//Set created from HashMap
		Set<String> keys = ids.keySet();
		
		//For loop to output contents of HashMap set
		for(String key : keys) {
			System.out.println(key);
			System.out.println(ids.get(key));
		}
	}
}
