
public class OptionalClass {
	public static void main(String[] args) {
		String[] s =  new String[10];
		s[0]= "Test";
		s[5] = "Welcome";
		for (int i=0; i<s.length;i++) {
			try {
				System.out.println(s[i].toLowerCase());
			}
			catch (NullPointerException npe){
				System.out.println(npe.getMessage());
			}
		}
	}
}
