// Majority Element; complete: n
// date: 25.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {0, 0, 0};
		System.out.println(majorityElement(nums));
	}	

	public static List<Integer> majorityElement2(int[] nums) {
    	List<Integer> l1 = new ArrayList<> ();

    	int element[] = new int[nums.length];
    	int freq[] = new int[nums.length];

    	int loc, n = 0;
    	for(int i=0; i<nums.length; i++) {
    		loc = search(element, n, nums[i]);
    		if(loc == -1) {
    			element[n] = nums[i];
    			freq[n] = 1;
    			n += 1;
    		}
    		else {
    			freq[loc] += 1;
    		}
    	}
    	int dlen = (int)Math.floor((double) nums.length / 2);
    	// System.out.println("dlen: "+dlen);
    	for(int i=0; i<n; i++) {
    		// System.out.println("element: "+element[i] + "\tFrequency: "+freq[i]);
    		if(freq[i] > dlen) l1.add(element[i]);
    	}
    	return l1;
    }    

    public static int search(int A[], int n, int x) {
    	for(int i=0; i<n; i++)
    		if(A[i] == x) return i; 

    	return -1;
    }
}