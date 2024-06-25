package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayChunker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to be stored in the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
        	System.out.println("Enter the element for the index value " + i +" :");
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the number of arrays you want to split it into: ");
		int arr_count = sc.nextInt();
		int remaining_arr = arr_count-1;
		int arr_len = arr.length;
		int remaining = arr.length;
		int k  =0;
		List<int []> chunkerlist = new ArrayList<int[]>();
		if(arr_len > arr_count){
			for (int i=1;i<=arr_count ;i++ )
			{
				System.out.println("Enter the number of elements to be stored in array " + i +" : ");
				int element_count = sc.nextInt();
				remaining = remaining - element_count;
				if(remaining >= remaining_arr){
						int[] chunk = new int[element_count];
						for(int j=0;j<chunk.length && k<arr.length;j++) {
							chunk[j] = arr[k];
							k++;
						}
						chunkerlist.add(chunk);
						remaining_arr--;
						
				}
				else{
					System.out.println("Not Possible to split the arrays");
					break;
				}
				
			}
		}
		else{
			System.out.println("Cannot split");
		}
		
		for (int[] chnk : chunkerlist) {
            System.out.print("[");
            for (int i = 0; i < chnk.length; i++) {
                System.out.print(chnk[i]);
                if (i < chnk.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
