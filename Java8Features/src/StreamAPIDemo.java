import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIDemo {
	static Integer square(int k) {
		return k*k;
	}

	static Integer cube(int j) {
		return j*j*j;
	}
	public static void main(String[] args) {
		List<Integer> myluckynum = Arrays.asList(1,2,3,4,5);
		List<Integer> yourluckynum = List.of(10,20,30,40,50);
		List <Integer> result = myluckynum.stream()
				.map(StreamAPIDemo::square)
				.collect(Collectors.toList());
		System.out.println(myluckynum);
		System.out.println(result);

		List <Integer> another_result = yourluckynum.stream()
				.map(StreamAPIDemo::cube)
				.collect(Collectors.toList());
		System.out.println(yourluckynum);
		System.out.println(another_result);
	}
}