// Sort Colors; complete: y
// date: 09.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {2,0,2,1,1,0};
		System.out.println("Initial Array: "+Arrays.toString(nums));
		Solution obj = new Solution();
		obj.sortColors(nums);
		System.out.println("After operation: "+Arrays.toString(nums));
	}
}

class Solution {
    public void sortColors(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<> ();
        
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        
        int loc0 = 0;
        if(map.containsKey(0)) loc0 = map.get(0);
        
        int loc1 = 0;
        if(map.containsKey(1)) loc1 = map.get(1);
        
        for(int i=0; i<nums.length; i++) {
            if(i < loc0) nums[i] = 0;
            else if(i >= loc0 && i < loc0 + loc1) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}