// Rotate Array; complete: n
// date: 04.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7};
		int k = 3;
		rotated(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	public static void rotated(int nums[], int k) {

		k = k % nums.length;

		int A[] = new int [k];
		int n = 0;
		int i = nums.length - k;
		while(i < nums.length) {
			A[n] = nums[i];
			n += 1;
			i += 1;
		}

		i = nums.length - k-1;

		while(i >= 0) {
			nums[i+k] = nums[i];
			i -= 1;
		}

		i = 0;
		while(i < k) {
			nums[i] = A[i];
			i += 1;
		}
	}
}