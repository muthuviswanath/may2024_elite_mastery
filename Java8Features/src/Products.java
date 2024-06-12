import java.util.ArrayList;

public class Products {

	void display(String s) {
		System.out.println(s);
		System.out.println("-----------------------");
	}

	public static void main(String[] args) {
		ArrayList<String> plist = new ArrayList<String>();
		plist.add("Mouse");
		plist.add("Keyboard");
		plist.add("Laptop");
		plist.add("Projector");
		plist.add("Printer");
		plist.add("Scanner");
		plist.forEach(new Products()::display);
	}

}
