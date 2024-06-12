
public interface Computation {
public static void main(String[] args) {
	NumericalInter ninter = (Object a, Object b)->{
		if (a instanceof Integer && b instanceof Integer) {
			int res1 = Integer.parseInt(a.toString());
			int res2 = Integer.parseInt(b.toString());
			System.out.println(res1%res2);
		}
		else if(a instanceof Double && b instanceof Double) {
			double res1 = Double.parseDouble(a.toString());
			double res2 = Double.parseDouble(b.toString());
			System.out.println(res1 + res2);
		}
		else {
			System.out.println(a.toString()+b);
		}
	};
	ninter.compute(10, 3);
	ninter.compute(10.2, 3.4);
	ninter.compute("Welcome ", 300);
}
}
