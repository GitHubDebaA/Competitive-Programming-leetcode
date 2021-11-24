// Search Insert Position; complete: y
// date: 04.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {};
		int target = 0;

		int AC = 0;
		int result = searchInsert(nums, target);
		System.out.println(result +"\t"+(AC == result));
	}

	public static int searchInsert(int nums[], int target) {
		int lb = 0, ub = nums.length-1;

		while(lb<=ub) {
			int mid = (lb+ub)/2;

			if(nums[mid] == target) return mid;
			if(nums[mid] > target) {
				ub = mid - 1;
			}
			else {
				lb = mid + 1;
			}
		} 
		return ub+1;
	}
}