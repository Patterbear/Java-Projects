import java.util.Objects;

public class Person {
	
	//Attributes defined
	String email;
	String ln;
	Position position;
	
	//Constructor method
	Person(String email, String ln){
		this.email = email;
		this.ln = ln;
	}
	
	//Empty constructor method created so that instantiation doesn't require giving any values
	Person(){
		
	}

	//Override for 'hashCode' method so that it incorporates all attributes from Person object
	@Override
	public int hashCode() {
		return Objects.hash(email, ln, position);
	}

	//Overwrite for 'equals' method so that it compares attribute values and not their memory addresses
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ln == null) {
			if (other.ln != null)
				return false;
		} else if (!ln.equals(other.ln))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	

}
