import java.util.HashSet;
import java.util.Iterator;

public class SetIterate {
	public static void main(String[] args) {
		HashSet<Integer> i =new HashSet<Integer>();
		i.add(10);
		i.add(20);i.add(20);
		i.add(45);
		i.add(90);
		Iterator<Integer> itr = i.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		String s = " ";
		
		String r = "";
		System.out.println(s.isEmpty());
		System.out.println(r.isBlank());
	}
}
