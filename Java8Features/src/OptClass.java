import java.util.Optional;

public class OptClass {
	public static void main(String[] args) {
		String[] sar= new String[10];
		sar[7] = "Welcome to Java 8 Features";
		String g = "Muthu";
		Optional<String> checkfornull_1 = Optional.ofNullable(g);
		if(checkfornull_1.isEmpty()) {
			System.out.println(checkfornull_1);	
		}
		else
			System.out.println(checkfornull_1.get());
	}
}
