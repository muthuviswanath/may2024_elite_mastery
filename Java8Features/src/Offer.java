import java.util.Scanner;

public class Offer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value for gender [M/F]:");
		char gender = scan.next().charAt(0);
		System.out.println("Enter the value for age:");
		int age = scan.nextInt();
		
		if(age >= 30 && age <=50) {
			if(gender=='M' || gender == 'm') {
				System.out.println("Flat 30% off");
			}
			else if(gender =='F' || gender == 'f') {
				System.out.println("Are your working? [true/false]:");
				boolean is_working = scan.nextBoolean();
				if(is_working) {
					System.out.println("Flat 40% off");
				}
				else {
					System.out.println("Flat 35% off");
				}
			}
			else {
				
			}
		}
		else {
			System.out.println("Offer not applicable for your age group");
		}
	}
}
