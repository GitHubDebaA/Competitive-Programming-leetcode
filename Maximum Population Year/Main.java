// Maximum Population Year; complete: y
// date: 30.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int logs[][] = {{1950,1961},{1960,1971},{1970,1981}};

		System.out.println(maximumPopulation(logs));
	}

	public static int maximumPopulation(int[][] logs) {
		int len = 2050 - 1950 + 1;
		int A[] = new int[len];

		for(int i=0; i<logs.length; i++) {
			int birth = logs[i][0];
			int died = logs[i][1];

			while(birth < died) {
				A[birth - 1950] += 1;
				birth += 1;
			}
		}

		int max = Integer.MIN_VALUE;
		int maxPopulationYear = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] > max) {
				max = A[i];
				maxPopulationYear = 1950 + i;
			}
		}

		return maxPopulationYear;
	}
}