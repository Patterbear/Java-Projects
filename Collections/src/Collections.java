public class Collections {

	public static void main(String[] args) {
		
		//Objects 'p' and 'q' created from class 'Person' with field 'email' and 'ln' passed in
		Person p = new Person("email@email.com", "McGregor");
		Person q = new Person("email@email.com", "McGregor");
		
		//Object 'pos1' and 'pos2' created from 'Position' class
		Position pos1 = new Position(10,10);
		Position pos2 = new Position(10,10);
		
		//Position fields assigned to objects 'p' and 'q'
		p.position = pos1;
		q.position = pos2;
		
		//Hash codes of objects ouputted
		System.out.println(p.hashCode());
		System.out.println(q.hashCode());
	}
}
