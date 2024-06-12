import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class OptClassMeth {
	static void isPresent(String s) {
		Optional<String> present_opt = Optional.of(s);
		System.out.println(present_opt.isPresent());
		
	}

	static void isEmpty(String s) {
		Optional<String> present_opt = Optional.of(s);
		System.out.println(present_opt.isEmpty());
	}
	
	static void assignEmpty()
	{
		Optional <String> mt = Optional.empty();
		System.out.println(mt.isEmpty());
	}
	
	static void ofNullableTest(String s) {
		Optional<String> present_opt = Optional.ofNullable(s);
		if(present_opt.isPresent()) {
			System.out.println(present_opt.get());
		}
		else {
			System.out.println(present_opt);
		}
	}
	
	
public static void main(String[] args) {
	List<String> nlist = new ArrayList<String>();
	nlist.add("Muthu");nlist.add("Rakesh");
	nlist.add("Viswas");nlist.add("Sandesh");
	nlist.add("Shreeya");nlist.add(null);
	
//	nlist.forEach(OptClassMeth::isPresent);
//	nlist.forEach(OptClassMeth::isEmpty);
	nlist.forEach(OptClassMeth::ofNullableTest);
	assignEmpty();
}
}
