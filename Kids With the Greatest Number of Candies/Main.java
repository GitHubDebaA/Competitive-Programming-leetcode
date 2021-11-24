// Kids With the Greatest Number of Candies, complete : y
// date : 21.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int candies[] = {2,3,5,1,3};
		int extraCandies = 3;

		List <Boolean> result = kidsWithCandies(candies, extraCandies);
		System.out.println(result);
	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<Boolean> ();
		int max = findMax(candies);

		for(int i=0; i<candies.length; i++) {
			if(candies[i] + extraCandies >= max) result.add(true);
			else result.add(false);
		}
		return result;
	}


	public static int findMax(int candies[]) {
		int max = candies[0];

		for(int i=1; i<candies.length; i++) {
			if(candies[i] > max) max = candies[i];
		}

		return max;
	}
}