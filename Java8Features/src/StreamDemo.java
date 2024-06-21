import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	int empno;
	String empname;
	public Employee(int empno, String empname) {
		this.empno = empno;
		this.empname = empname;
	}

}
public class StreamDemo {
	static Integer cubes(int a) {
		return a*a*a;
	}

	//	static Employee empdet
	public static void main(String[] args) {
		//Integer List:
		List<Integer> my_num = Arrays.asList(10,12,23,34,45,56,67);
		List<String> my_names = List.of("Muthu","Ravi","Rakesh","Viswas","Shreeya","Sandesh","Poornima");
		List<Employee> my_emp = List.of(new Employee(12,"Muthu"),new Employee(14,"Ravi"));
		// Map 

		List<Integer> cubes = my_num.stream()
				.map(StreamDemo::cubes)
				.collect(Collectors.toList());
		System.out.println(cubes);
		List<String> selected_candidates = my_names.stream()
				.filter(str -> str.endsWith("sh"))
				.collect(Collectors.toList());
		List<Employee> selected_emp = my_emp.stream()
				.filter(emp -> emp.empname.startsWith("R"))
				.collect(Collectors.toList());
		
		for(Employee e:selected_emp) {
			System.out.println(e.empname);
		}
		
		Iterator<Employee> emp_itr = selected_emp.iterator();
		while(emp_itr.hasNext()) {
			System.out.println(emp_itr.next().empname);
		}
		for(int i=0;i<selected_emp.size();i++) {
			System.out.println(selected_emp.get(i).empname);
		}
		// reduce
		int odd_num = my_num.stream()
					.filter(odd -> odd % 2 !=0 )
					.reduce(1,(res,i) -> res * i);
		System.out.println(odd_num);
	}
}
