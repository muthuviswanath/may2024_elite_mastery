package reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class ReflectionClass {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
		Class<?> drvclass = DerivedClass.class;
		
		drvclass = Class.forName("reflections.DerivedClass");
		System.out.println(drvclass.getCanonicalName());
		
		Class<?> strclass= String.class;
		System.out.println(strclass.getCanonicalName());
		
		Class<?> characterclass = Character.class;
		System.out.println(characterclass.getCanonicalName());
		
		Class<?> cIntegerArray = Class.forName("[I");
		System.out.println(cIntegerArray.getCanonicalName());
		
		Class<?> cDoubleArray = Class.forName("[D");
		System.out.println(cDoubleArray.getCanonicalName());
		
		Class<?> twoDIntegerArray = int[][].class;
		System.out.println(twoDIntegerArray.getCanonicalName());
		
		Class<?> superClass = Class.forName("reflections.DerivedClass").getSuperclass();
		System.out.println(superClass);
		
		Class<?> supercl = Class.forName("java.util.LinkedList").getSuperclass();
		System.out.println(supercl);
		
		System.out.println(Object.class.getSuperclass());
		
		Class<?>[] classes = drvclass.getClasses();
		System.out.println(Arrays.toString(classes));
		
		for (Class<?> my_classes : classes) {
			System.out.println(my_classes);
		}
		
		Class<?>[] explicitly_mentioned_classes = Class.forName("reflections.DerivedClass").getDeclaredClasses();
		for (Class<?> my_classes : explicitly_mentioned_classes) {
			System.out.println(my_classes);
		}
		System.out.println(Class.forName("reflections.BaseInterface").getPackage());
		
		System.out.println(Modifier.toString(drvclass.getModifiers()));
		
		TypeVariable<?>[] typeparameters = Class.forName("java.util.LinkedList").getTypeParameters();
		for (TypeVariable<?> tv : typeparameters) {
			System.out.print(tv.getName()+ ", ");
		}
		System.out.println();
		Field privatefield= Class.forName("reflections.DerivedClass").getDeclaredField("name");
		privatefield.setAccessible(true);
		DerivedClass drvcl = new DerivedClass(10);
		System.out.println(privatefield.get(drvcl));
		
		Method methods = Class.forName("reflections.BaseClass").getDeclaredMethod("execution", null);
		methods.setAccessible(true);
		methods.invoke(null, null);
		
		Constructor<?> construct = Class.forName("reflections.DerivedClass").getConstructor(int.class);
		System.out.println(construct.getName());
		
		Constructor<?> prvtconstr = Class.forName("reflections.DerivedClass").getDeclaredConstructor();
		prvtconstr.setAccessible(true);
		DerivedClass d = (DerivedClass) prvtconstr.newInstance();
		
	}
}
