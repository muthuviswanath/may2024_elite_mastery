import java.util.LinkedList;
import java.util.List;

public class Muthu {

	void display(String msg) {
		System.out.println(msg);
	}
	
	void show(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		List<String> my_msgs = new LinkedList<String>();
		my_msgs.add("Hello");my_msgs.add("Good Morning");
		my_msgs.add("Good Night");
		my_msgs.add("Get Lost");
		
		for(String s:my_msgs) {
			new Muthu().display(s);
		}
		
		my_msgs.forEach(new Muthu()::display);
		my_msgs.forEach(new Muthu()::show);
	}
}
