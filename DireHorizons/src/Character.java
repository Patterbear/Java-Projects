import java.util.ArrayList;
import java.util.Arrays;

public class Character {
	
	public String firstName;
	public String lastName;
	public String countryOfOrigin;
	public int age;
	public String profession;

	
	public int strength = 0;
	public int speed = 0;
	public int intelligence = 0;
	public int charm = 0;
	public int leadership = 0;
	public int technology = 0;
	public int marksmanship = 0;
	public int survivability = 0;
	
	public ArrayList<String> perks;
	
	public String getfullName() {
		return (firstName + " " + lastName);
	};
	
	public void outputStats() {
		System.out.println("Strength: " + Integer.toString(strength));
		System.out.println("Speed: " + Integer.toString(speed));
		System.out.println("Intelligence: " + Integer.toString(intelligence));
		System.out.println("Charm: " + Integer.toString(charm));
		System.out.println("Leadership: " + Integer.toString(leadership));
		System.out.println("Technology: " + Integer.toString(technology));
		System.out.println("Marksmanship: " + Integer.toString(marksmanship));
		System.out.println("Survivability: " + Integer.toString(survivability));
		
	}
	
	public void outputPerks() {
		System.out.println(Arrays.toString(perks.toArray()));
	}
	
}
