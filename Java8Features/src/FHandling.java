import java.io.File;
public class FHandling {
	public static void main(String[] args) {



		// Get the Current Working Directory
		System.out.println(new File(".").getAbsolutePath());

		// Changing the Current Working Directory
		File directory = new File("C:\\Users\\Muthu\\Desktop\\carousel_images");
		if (directory.exists() && directory.isDirectory()) {
			System.setProperty("user.dir", directory.getAbsolutePath());
		}
		System.out.println(new File(".").getAbsolutePath());

		// List Directories and Files
		File[] files = new File(".").listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}

		// Create Directories
		File newDirectory = new File("Bakrid Images");
		if (!newDirectory.exists()) {
			newDirectory.mkdir();
		}
		files = new File(".").listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}


	}
}