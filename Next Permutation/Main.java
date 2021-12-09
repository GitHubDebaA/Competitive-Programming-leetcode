// Next Permutation; complete: y
// date: 09.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {1, 2, 3};
		Solution obj = new Solution();
		System.out.println("Initial Array: "+Arrays.toString(nums));
		obj.nextPermutation(nums);
		System.out.println("After operation: "+Arrays.toString(nums));
	}
}

class Solution {
    public void nextPermutation(int[] nums) {
		if(nums.length<=1) return;
		
		int i = nums.length-2;
		while(i>=0 && (nums[i] >= nums[i+1])) i--;
		if(i>=0)
		{
			int j = nums.length-1;
			while(nums[j] <= nums[i]) j--;
			Swap(nums,i,j);
		}
		Reverse(nums,i+1);        
    }
    
   	public void Swap(int[] a, int x ,int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void Reverse(int [] a, int i)
	{
		int j = a.length-1;
		while(i<j) Swap(a,i++,j--);
	}
}
