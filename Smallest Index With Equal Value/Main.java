// Smallest Index With Equal Value; complete: y
// date: 04.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {2,1,3,5,2};
		System.out.println(smallestEqual(nums));
	}

	public static int smallestEqual(int[] nums) {
		int i=0;
		while(i < nums.length) {
			if(i % 10 == nums[i]) return i;
			i += 1;
		}
		return -1;
    }
}