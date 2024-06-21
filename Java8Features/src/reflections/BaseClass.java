package reflections;

public class BaseClass {
	public int baseId;
	private static void execution() {
		System.out.println("Private static Execution method of Base Class");
	}
	public int calculate() {
		System.out.println("Public Calculate method that return an integer value");
		return 0;
	}
	public static int demonstrate() {
		System.out.println("Public static demonstrate method that return an integer value");
		return 0;
	}
	void hang() {
		System.out.println("default hang method that returns nothing");
	}
	
	public enum BaseClassEnumerator{}
}
