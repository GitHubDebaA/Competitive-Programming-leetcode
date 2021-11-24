// Shuffle the problem, complete : y
// date : 21.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {2,5,1,3,4,7};
		// the size of num is always even
		int n = nums.length / 2;
		System.out.println(Arrays.toString(nums));
		nums = shuffle(nums, n);
		System.out.println(Arrays.toString(nums));
	}

	public static int[] shuffle(int[] nums, int n) {
		int numsCopy[] = new int[2*n];

		int xi = 0, yi = n, i = 0;

		while(xi < n) {
			numsCopy[i] =nums[xi];
			i += 1;

			numsCopy[i] = nums[yi];
			i += 1;
			xi += 1;
			yi += 1;
		}
		return numsCopy;
	}
}