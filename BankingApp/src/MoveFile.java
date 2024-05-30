import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveFile {
public static void main(String[] args) throws IOException {
	Path temp_path = Files.move(Paths.get("C:\\Users\\Muthu\\Desktop\\Alpha.txt"), Paths.get("D:\\Beta.txt"));
	if (temp_path != null) {
		System.out.println("File moved successfully");
	}
	else {
		System.out.println("Issue with the file");
	}
}
}
