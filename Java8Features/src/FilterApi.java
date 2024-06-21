import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterApi {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Rakesh","Sandesh","Shreeya","Muthu");
		List<String> final_names = names.stream()
								   .filter(str -> str.endsWith("sh"))
								   .collect(Collectors.toList());
		System.out.println(names);
		System.out.println(final_names);
		
		//Sort
		List<String> sorted_names = names.stream()
									.sorted()
									.collect(Collectors.toList());
		System.out.println(sorted_names);
		
		//Distinct
		List<Integer> num_lst = Arrays.asList(10,10,20,30,20,40);
		List<Integer> unique_numbers = num_lst.stream()
									   .distinct()
									   .collect(Collectors.toList());
		System.out.println(unique_numbers);
		
		List<Integer> reverse_order = num_lst.stream()
				   					   .sorted(Comparator.reverseOrder())
				   					   .collect(Collectors.toList());
		System.out.println(reverse_order);
		

	}
}
