import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class StreamsFromFiles {
public static void main(String[] args) throws IOException {
	Stream<String> para = Files.lines(Path.of("C:\\Users\\Muthu\\OneDrive\\Desktop\\Dhoni.txt"));
	para.forEach(System.out::println);
	
	BufferedReader bread = Files.newBufferedReader(Paths.get("C:\\Users\\Muthu\\OneDrive\\Desktop\\Dhoni.txt"));
	Stream<String> lines = bread.lines();
	lines.forEach(System.out::println);
	
	List<String> strList = Files.readAllLines(Path.of("C:\\Users\\Muthu\\OneDrive\\Desktop\\Dhoni.txt"));
	Stream<String> sentence = strList.stream();
	sentence.forEach(System.out::println);
}
}
