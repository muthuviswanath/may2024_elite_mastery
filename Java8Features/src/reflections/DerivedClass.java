package reflections;

public class DerivedClass extends BaseClass implements BaseInterface{
	
	public int publicId = 23;
	private String name= "Private String Name";
	protected boolean isProtected;
	Object defaultObject;
	
	public DerivedClass(int i) {
		this.publicId = i;
	}
	
	private DerivedClass() {
		System.out.println("Private Constructor of derived class");
	}
	

	@Override
	public void display() {
		System.out.println("Implementation provided by DerivedClass");
		
	}

	@Override
	public int show(String s) {
		System.out.println("Implementation provided by DerivedClass for the variable s as: " + s);
		return 0;
	}
	
	public class PublicNestedClass{}
	private class PrivateNestedClass{}
	protected class ProtectedNestedClass{}
	class DefaultNestedClass{}
	
	enum DefaultEnums{}
	public enum publicEnums{}
	
	abstract interface PublicNestedInterface{}
	

}
