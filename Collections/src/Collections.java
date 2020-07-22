import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

	public static void main(String[] args) {
		
		//Object a created from class 'Admin'
		Admin a = new Admin();
		
		//Assigning attributes to object 'a'
		a.email = "test@test.com";
		a.ln = "McGregor";
		
		//ArrayList created to store objects created from 'Admin'class
		ArrayList<Admin> admins = new ArrayList<Admin>();
		admins.add(a);
		
		//List created from casting 'admins' to type 'Person'
		List<Person> people = (List<Person>)(List<?>)admins;		
		
		//Method called
		doSomething(people);

	}
	
	//Method to output contents of the 'p_list' List.
	static void doSomething(List<Person> p_list) {
		for(Person p : p_list) {
			System.out.println(p.email + " " + p.ln);
		}
	}
	
}
