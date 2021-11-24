// Count Number of Pairs With Absolute Difference K; complete : y
// date : 27.09.2021


import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {1,2,2,1};
		int k = 1;

		System.out.println(countKDifference(nums, k));
	}

	public static int countKDifference(int nums[], int k) {
		int count = 0;
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] - nums[j] == k || nums[i] - nums[j] == -k) count += 1;
			}
		}
		return count;
	}
}