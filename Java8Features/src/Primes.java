
public class Primes {

	boolean isPrime(int n) {
		int factor = 0;
		for (int i=1; i<=n; i++) {
			if(n%i==0) 
			{
				factor++;
			}
		}
		if(factor==2) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		Primes p = new Primes();
		System.out.println(p.isPrime(35));
				
	}
}
