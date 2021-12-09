// Maximum Subarray; complete: y
// date: 09.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		Solution obj = new Solution();
		System.out.println(obj.maxSubArray(nums));
	}
}


class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE, sum = 0; 
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum > maxsum) maxsum = sum;
            
            if(sum < 0) sum = 0;
        }
        
        return maxsum;
    }
}
