// Majority Element II; complete: y
// date: 24.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums[] = {0, 0, 0};
		System.out.println(majorityElement2(nums));
	}

	/*
		Runtime: 12 ms, faster than 15.46% of Java online submissions for Majority Element II.
		Memory Usage: 48 MB, less than 6.90% of Java online submissions for Majority Element II.
	*/
    public static List<Integer> majorityElement(int[] nums) {
    	List<Integer> l1 = new ArrayList<> ();
		HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i=0; i<nums.length; i++) {
    		if(map.containsKey(nums[i])) {
    			map.put(nums[i], map.get(nums[i]) + 1);
    		}
    		else {
    			map.put(nums[i], 1);
    		}
    	}
   		int dlen = (int)Math.floor((double) nums.length / 3);

    	for(Map.Entry<Integer, Integer> element : map.entrySet()) {
    		if(element.getValue() > dlen) l1.add(element.getKey());
    	}

    	return l1;
    }

    /*
		Runtime: 5 ms, faster than 49.36% of Java online submissions for Majority Element II.
		Memory Usage: 47.1 MB, less than 12.39% of Java online submissions for Majority Element II.
    */
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
    	int dlen = (int)Math.floor((double) nums.length / 3);
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