
public class Dog {
	private int age;
	private String name;
	
	public Dog(int paramAge) {
		//assign the age attribute to the "input" aka parameter/argument
		//recall that this value is coming from some other set of code
		age = paramAge;
		name = "Murphy";
		
		
	}
	
	public String toString() {
		//return a String representation of a cat object
		return name + " " + age;
}
}
