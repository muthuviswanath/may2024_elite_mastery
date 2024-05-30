
public class CountDigits {
	public static void main(String[] args) {
		
		int count = 0;
		for(int n = 467384; n!=0 ; n = n/10)
		{
			count++; // count = 5 + 1 = 6
		}
		System.out.println("Total number of digits: " + count);
	}
}
