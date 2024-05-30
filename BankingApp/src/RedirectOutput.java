import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutput {
public static void main(String[] args) throws FileNotFoundException {
	PrintStream fout = new PrintStream("Receipt.txt");
	
	PrintStream console = System.out;
	System.setOut(fout);
	System.out.println("Hello");
	System.out.println("Hello I am back");
	System.setOut(console);
	System.out.println("Tata Bye Bye Katham");
}
}
