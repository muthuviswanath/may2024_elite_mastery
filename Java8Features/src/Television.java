import java.util.ArrayList;
import java.util.function.Function;

public class Television extends Electronics{
	@Override
	String display(String str) {
//		Function<String, String> myfunc= super::display;
//		String msg = myfunc.apply(str);
//		msg += "Never come back " + str;
//		System.out.println(msg);
//		return msg;
		super.display(str);
		System.out.println(str);
		return "";
		
	}
	public static void main(String[] args) {
		ArrayList<String> tvlist = new ArrayList<String>();
		tvlist.add("Onida");
		tvlist.add("LG");
		tvlist.add("Sony");
		tvlist.add("Samsung");
		tvlist.add("MI");
		Television t = new Television();
//		tvlist.forEach(new Television()::display);
		
		for(String s:tvlist) {
			t.display(s);
		}
	}
}
