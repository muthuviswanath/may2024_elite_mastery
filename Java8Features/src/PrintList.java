import java.util.ArrayList;

public class PrintList {
	static int sum = 0;
	static int prod = 1;
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=1; i<=40; i++) {
			al.add(i);
		}
		
		
		al.forEach(n ->{
			
			if (n%2==0) {
				sum += n;
			}
			else {
				prod *= n;
			}
		});
		System.out.println(sum);
		System.out.println(prod);
	}
}
