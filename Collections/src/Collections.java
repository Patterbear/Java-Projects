public class Collections {

	public static void main(String[] args) {
		Item<Person> item = new Item<Person>();
		Person p = new Person("Hello", "Hello");
		item.setX(p);
	}
}
