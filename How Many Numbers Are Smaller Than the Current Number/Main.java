// How Many Numbers Are Smaller Than the Current Number; complete : n
// date : 21.09.2021


import java.util.*;

class Main {
	public static void main(String args[]) {
		int nums[] = {8,1,2,2,3};
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
	}

    public static int[] smallerNumbersThanCurrent(int[] nums) {
    	int result[] = new int [nums.length];
    	for(int i=0; i<nums.length; i++) {
    		result[i] = 0;
    		for(int j=0; j<nums.length; j++) {
    			if(i != j && nums[j] < nums[i])  result[i] ++;
    		}
    	}
    	return result;
    }
}