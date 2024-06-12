import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class Laptop extends Product{
	@Override
	String displayProduct(String str) {
		Function<String, String> func = super::displayProduct;
		String prod_name= func.apply(str);
		prod_name += " Your product " + str +"will be delivered to your registered address \n";
		System.out.println(prod_name);
		return prod_name;
	}
	
	public static void main(String[] args) {
		List<String> prd_list= new ArrayList<String>();
		System.out.println("Enter the number of products: ");
		Scanner scan = new Scanner(System.in);
		int items_count = scan.nextInt();
		for (int items = 1;  items <= items_count; items++) {
			System.out.println("Enter the Product name for Item " + items+ " :");
			prd_list.add(scan.next());
		}
		scan.close();
		System.out.println("\n\nYour list of items: ");
		prd_list.forEach(new Laptop()::displayProduct);
	}
}
