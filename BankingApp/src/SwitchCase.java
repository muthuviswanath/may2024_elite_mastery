
public class SwitchCase {
	public static void main(String[] args) {
		int age = 30;
		switch (age) {
		case 10: {
			System.out.println("Ten");
			break;
		}
		case 20: {
			System.out.println("Twenty");
			break;
		}
		case 30: {
			System.out.println("Thirty");
			break;
		}
		case 40: {
			System.out.println("Fourty");
			break;
		}
		default:
			System.out.println("Age is not a number");
		}
	}
}
