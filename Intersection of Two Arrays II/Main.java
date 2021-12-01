// Intersection of Two Arrays II; complete: n
// date: 01.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int nums1[] = {1,2,2,1};
		int nums2[] = {2,2};

		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);    

    	// System.out.println(Arrays.toString(nums1));
    	// System.out.println(Arrays.toString(nums2));

    	List<Integer> l1 = new ArrayList<> ();

    	int i = 0, j = 0, k;

    	while(i < nums1.length && j < nums2.length) {
    		// System.out.println("i: "+i+"\tj: "+j);
    		if(nums1[i] == nums2[j]) {
    			// System.out.println("\tnums1[i] == nums2[i]");
    			l1.add(nums1[i]);
    			i += 1;
    			j += 1;
    		}
    		else if(nums1[i] < nums2[j]) {
    			// System.out.println("\tnums1[i] < nums2[i]");
    			k = i;
    			while(k < nums1.length && nums1[k] < nums2[j]) {
    				k += 1;
    			}
    			i = k;
    		}
    		else {
    			// System.out.println("\tnums1[i] > nums2[i]");
    			k = j;
    			while(k < nums2.length && nums2[k] < nums1[i]) k += 1;

    			j = k;
    		}
    	}

    	int A[] = new int[l1.size()];

    	k = 0;
    	for(int val : l1) {
    		A[k] = val;
    		k += 1;
    	}

    	return A;
    }
}