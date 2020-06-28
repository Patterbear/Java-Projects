public class Collections {

	public static void main(String[] args) {
		
		//Object 'item' created from 'Item' generic class with type 'Person'
		Item<Person> item = new Item<Person>();
		
		//Attributes assigned using default constructor method 'new'
		Person p = new Person("Hello", "Hello");
		
		//'x' attribute is set as object 'p' using 'setX' method
		item.setX(p);
	}
}
