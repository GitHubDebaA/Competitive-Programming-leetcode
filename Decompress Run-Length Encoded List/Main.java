// Decompress Run-Length Encoded List; complete : y
// date : 27.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {1,1,2,3};
		System.out.println(Arrays.toString(decompressRLElist(nums)));
	}

	public static int[] decompressRLElist(int nums[]) {
		int i = 0, len = 0, x, loc, n;
		while(i < nums.length) {
			len += nums[i];
			i += 2;
		}

		int arr[] = new int[len];

		i = 0;
		loc = 0;
		n = 0;
		while(i < nums.length) {
			n += nums[i];
			i += 1;
			x = nums[i];

			while(loc < n) {
				arr[loc] = x;
				loc += 1;
			}

			i += 1;
		}
		return arr;
	}
}