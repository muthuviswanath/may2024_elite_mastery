import java.util.ArrayList;

public class Animal {
	public Animal(String s) {
		System.out.println("Hello "+ s);
	}
	
	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<String>();
		animals.add("Humans");
		animals.add("Domesticated Wolf");
		animals.add("Lion");
		animals.forEach(Animal::new);
	}
}
