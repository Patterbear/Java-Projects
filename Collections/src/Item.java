public class Item <T> {
	
	//Attribute 'x' of given type is defined as private
	private T x;

	//Method to return the value of 'x'
	T getX() {
		return x;
	}
	
	//Method to set the value of 'x'
	void setX(T x) {
		this.x = x;
	}
}
