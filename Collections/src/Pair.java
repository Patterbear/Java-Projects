public class Pair <T, U> {
	
	//Attribute 'x' and 'y' of given types are defined as private
	private T x;
	private U y;

	//Method to return the value of 'x'
	T getX() {
		return x;
	}
	
	//Method to set the value of 'x'
	void setX(T x) {
		this.x = x;
	}
	
	//Method to return the value of 'y'
	U getY(){
		return y;
	}
	
	//Method to set the value of 'y'
	void setY(U y) {
		this.y = y;
	}
	
}
