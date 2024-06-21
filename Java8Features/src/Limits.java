import java.util.stream.Stream;

public class Limits {
	public static void main(String[] args) {
		Stream.iterate(1, incr -> incr +1)
		.filter(incr -> incr%2 ==0)
		.limit(10)
		.forEach(System.out::println);
	}
}
