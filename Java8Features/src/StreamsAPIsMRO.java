import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamsAPIsMRO {
	public static void main(String[] args) {
		Stream<String> name_stream = Stream.of("Muthu","Rakesh","Ravi","Viswas","Sandesh");
		name_stream.forEach(System.out::println);

		ArrayList<Integer> alst = new ArrayList<Integer>();
		for (int i=1;i<=5;i++) {
			alst.add(i*i);
		}
		alst.forEach(System.out::println);
	}
}
