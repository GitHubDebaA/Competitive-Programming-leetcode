// Sum of All Odd Length Subarrays; complete : y
// date : 27.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int arr[] = {1,4,2,5,3};
		System.out.println(sumOddLengthSubarrays(arr));	
	}

	public static int sumOddLengthSubarrays(int arr[]) {
		int c=0, i, sum, j;

		i = 0;
		while(i < arr.length) {

			j = i;
			sum = arr[j];
			c += sum;
			// System.out.println(sum);
			j += 2;
			while(j <arr.length) {
				sum += arr[j-1] + arr[j];
				c += sum;
				j += 2;
				// System.out.println(sum);
			}
			i += 1;
		}
		return c;
	}
}