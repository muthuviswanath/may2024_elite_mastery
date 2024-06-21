import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Product_New{
	int id;
	String name;
	double price;
	public Product_New(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
public class ProductStream {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of products to be stored: ");
		int n = sc.nextInt();
		List<Product_New> prd_lst = new ArrayList<Product_New>(); 
		for (int i=0; i<n;i++) {
			System.out.println("Enter the product id for product " + (i+1) +" :");
			int pid = sc.nextInt();
			System.out.println("Enter the product name for product " + (i+1) +" :");
			String pname = sc.next();
			System.out.println("Enter the product price for product " + (i+1) +" :");
			double pprice = sc.nextDouble();
			prd_lst.add(new Product_New(pid, pname, pprice));
		}
		//Collectors Summing Double
		double total = prd_lst.stream()
				.collect(Collectors.summingDouble(prd -> prd.price));
		System.out.println("Product total: "+total);
		
		//Max
		Product_New max_Prod = prd_lst.stream()
							.max((prd_1,prd_2) -> prd_1.price > prd_2.price?1:-1).get();
		System.out.println(max_Prod.name + " | " + max_Prod.price);
		
		//Min
		Product_New min_Prod = prd_lst.stream()
							.min((prd_1,prd_2) -> prd_1.price > prd_2.price?1:-1).get();
		System.out.println(min_Prod.name + " | " + min_Prod.price);
	}
}