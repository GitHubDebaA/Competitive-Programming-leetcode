// Maximum Product Subarray; complete: y
// date: 02.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {0};

		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] nums) {
    	int i, j, product = Integer.MIN_VALUE;
    	if(nums.length == 0) return 0;

    	i = 0;
    	while(i < nums.length) {
    		int temp = 1;
    		j = i;
    		while(j < nums.length) {
    			temp = temp * nums[j];
    			if(temp > product) {
    				product = temp;
    			}
    			j += 1;
    		}
    		i += 1;
    	}    
    	return product;
    }
}