import java.util.Arrays;

public class MyCheck {
	static void show(Object s) {
		System.out.println(s);
	}

	static void disp(Object s) {

		System.out.println(s);
		if (s instanceof Arrays) {
			String myarr = ((Arrays) s).toString(); 
			for (int i=0; i<myarr.length(); i++) {
				System.out.println(myarr.charAt(i));
			}
		}
	}

public static void main(String[] args) {
	//		Checkable c = (String s)->{System.out.println(s);};
	Checkable c = MyCheck::show;
	//		Checkable c = new Checkable() {
	//			public void display(String s) {
	//				System.out.println(s);
	//			};
	//		};
	//		c.display("Muthu");
	//		c.display(23);
	c.display("Abhilash");
	c = MyCheck::disp;
	c.display(34);
	c.display(34.56);
	c.display(true);

}
}
