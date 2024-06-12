class Animals { 
	protected String name; 
	Animals(String name) { 
		this.name = name; 
	} 
} 

public class Dog extends Animals {

	Dog(String name) {
		super(name); 
	}
} 