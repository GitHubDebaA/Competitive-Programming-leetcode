// Number of Good Pairs; complete : y
// date : 21.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {1,2,3,1,1,3};

		int goodPair = numIdenticalPairs(nums);
		System.out.println(goodPair);
	}

	public static int numIdenticalPairs(int[] nums) {
		int goodPair = 0;

		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] == nums[j]) goodPair += 1;
			}
		}
		return goodPair;
	}
}