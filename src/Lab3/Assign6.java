package Lab3;

import java.util.Random;
import java.util.Scanner;

public class Assign6 {
	
	
	
	private static Scanner in;
	public void sort(int arr[]) {
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = in.nextInt();
		int arr[] = new int [n];
		Random rand = new Random();
		
		for(int i=0; i<n; i++) {
			arr[i] = Math.abs((rand.nextInt()%n));
		}
	
		
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			if(i==0) {
				System.out.print(arr[i]);
			}else {
				System.out.print(","+arr[i]);
			}
		}
		System.out.print("]");
		
		
		System.out.print("\nSorted array: ");
		Assign6 a = new Assign6();
		a.sort(arr);
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			if(i==0) {
				System.out.print(arr[i]);
			}else {
				System.out.print(","+arr[i]);
			}
		}
		System.out.print("]");
		
		System.out.println("\nEnter search value: ");
		int sValue = in.nextInt();
		
		
		
		int left=0;
		int right = arr.length-1;
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(arr[mid] == sValue) {
				
				System.out.println("Found "+arr[mid]+" at index:"+ mid);
				return;
			}
			else if(arr[mid] > sValue) {
				right = mid - 1;
			}
			else if(arr[mid] < sValue) {
				left = mid + 1;
			}	
		}
		
		System.out.println("Not found \n");
		
	

	}
	
}
