// Create Target Array in the Given Order; complete : y
// date : 27.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {1};
		int index[] = {0};

		System.out.println(Arrays.toString(createTargetArray(nums, index)));
	}

	public static int[] createTargetArray(int nums[], int index[]) {
		int targetArr[] = new int[nums.length];
		int n = 0;

		for(int i=0; i<nums.length; i++) {
			int loc = index[i];

			if(loc < n) {
				int j = n-1;
				while(j >= loc) {
					targetArr[j+1] = targetArr[j];
					j -= 1;
				}
			}
			targetArr[loc] = nums[i];
			n += 1;
		}
		return targetArr;
	}
}