// Squares of a Sorted Array; complete: n
// date: 04.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {-4,-1,0,3,10};

		int result[] = sortedSquares(nums);
		System.out.println(Arrays.toString(result));
	}

	public static int[] sortedSquares(int nums[]) {
		for(int i=0; i<nums.length; i++) {
			nums[i] *= nums[i];
		}

		Arrays.sort(nums);

		return nums;
	}
}