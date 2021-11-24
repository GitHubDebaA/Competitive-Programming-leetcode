// Binary Search; complete: y
// date: 04.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {1,0,3,5,9,12};
		int target = 9;

		System.out.println(search(nums, target));
	}

	public static int search(int nums[], int target) {
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
		return -1;
	}
}