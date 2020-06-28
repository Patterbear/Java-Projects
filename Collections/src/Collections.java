import java.util.ArrayList;
import java.util.Arrays;

public class Collections {

	public static void main(String[] args) {
		
		//ArrayList created to store objects created from 'Person' class
		ArrayList<Person> people = new ArrayList<Person>();
		
		//Object a created from class 'Admin'
		Admin a = new Admin();
		
		//Object 'a' added to 'people' ArrayList
		people.add(a);
		
		//ArrayList created to store objects created from 'Admin'class
		ArrayList<Admin> admins = new ArrayList<Admin>();
		
		//ArrayList created to store Admin objects as 'Person' types so that the methods can use them
		ArrayList<Person> adminsAsPerson = new ArrayList<Person>();
		
		//For loop to add all of the objects in the 'admin' ArrayList into the 'adminsAsPerson' ArrayList
		for(Admin admin : admins) {
			adminsAsPerson.add((Person)admin);
		}
		
		//Methods called
		doSomething(a);
		doSomethingElse(adminsAsPerson);
		
	}
	
	//Method to output memory address of object 'p'
	static void doSomething(Person p) {
		System.out.println(p);
	}
	
	//Method to output contents of the 'p_arrayList' ArrayList.
	static void doSomethingElse(ArrayList<Person> p_arrayList) {
		System.out.println(Arrays.deepToString(p_arrayList.toArray()));
	}
	
}
