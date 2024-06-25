package arrays;

import java.util.Scanner;

public class SplitArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a[] = {1,2,3,4,5,6,7,8,9,10,11};
		System.out.println("Enter the element you want to be stored in first array");
		int fsize = s.nextInt();
		System.out.println("Elements of First Array");
		for(int i=0; i<fsize; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("Elements of Second Array");
		for(int i=fsize; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}
}
