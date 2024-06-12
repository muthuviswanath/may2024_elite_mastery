import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		Scanner	scan = new Scanner(System.in);
		System.out.println("Enter a byte value");
		byte b = scan.nextByte();
		System.out.println("Enter a short value");
		short s = scan.nextShort();
		System.out.println("Enter a int value");
		int i = scan.nextInt();
		System.out.println("Enter a long value");
		long l  = scan.nextLong();
		System.out.println("Enter a double value");
		double d= scan.nextDouble();
		System.out.println("Enter a float value");
		float f = scan.nextFloat();
		System.out.println("Enter a boolean value");
		boolean bl = scan.nextBoolean();
		//To fetch only one word as input
		System.out.println("Enter a single word");
		String st = scan.next();
		//To fetch more than one word or a sentence
		System.out.println("Enter a sentence");
		scan.nextLine();
		String sent = scan.nextLine();
		System.out.println("Enter a character");
		char c = scan.next().charAt(0);
		scan.close();
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(d);
		System.out.println(f);
		System.out.println(bl);
		System.out.println(st);
		System.out.println(sent);
		System.out.println(c);
	}
}
