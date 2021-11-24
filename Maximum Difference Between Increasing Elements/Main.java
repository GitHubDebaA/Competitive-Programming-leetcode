// Maximum Difference Between Increasing Elements; complete : y
// date : 26.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {1,5,2,10};
		System.out.println(maximumDifference(nums));
	}

	public static int maximumDifference(int nums[]) {
		int maxDif = -1;
		for(int i=0; i<nums.length; i++) {
			for(int j = i+1; j<nums.length; j++) {
				if(nums[j] > nums[i]) {
					if(nums[j] - nums[i] > maxDif) {
						maxDif = nums[j] - nums[i];
					}
				}
			}
		}
		return maxDif;
	}
}