package arrays;

public class DynamicArrays {

	private  int arr[];
	private  int len;
	public DynamicArrays(int size) {
		arr = new int[size];
	}

	public void add(int element) {
		if(arr.length == len) {
			int newArray[] = new int[len+1];
			for(int i=0; i<len;i++) {
				newArray[i] = arr[i];
			}
			arr = newArray;
		}
		arr[len++] = element;
	}
	public  void printArray() {
		if (arr == null){
			System.out.println("null");
		}
		else {
			int arrmax = arr.length-1; 
			if (arrmax == -1)
			{
				System.out.println("[]");
			}
			else {
				System.out.print("[");
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i]);
					if(i==len-1) {
						System.out.print("]");
					}
					else{
						System.out.print(", ");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		DynamicArrays da = new DynamicArrays(5);
		da.add(10);da.add(20);
		da.add(10);da.add(40);
		da.printArray();
		System.out.println();
		da.add(10);da.add(10);
		da.printArray();
	}
}

