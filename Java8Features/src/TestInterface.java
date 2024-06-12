import java.util.ArrayList;

public class TestInterface {
	public static void main(String[] args) {
		ArrayList<Integer> alist = new ArrayList<Integer>();
		for (int i=1; i<=40; i++)
			alist.add(i);
		OperationalInterface oint = new OperationalInterface() {

			@Override
			public void display(ArrayList<Integer> ele) {
				int sum = 0;
				int prod = 1;
				for(int i=0;i<ele.size(); i++) {
					if (i%2==0) {
						prod *= ele.get(i);
					}
					else {
						sum += ele.get(i);
					}
				}
				System.out.println("Sum: " + sum);
				System.out.println("Product: " + prod);
			}
		}; 
		oint.display(alist);

	}


}
