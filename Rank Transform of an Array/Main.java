// Rank Transform of an Array; complete: y
// date: 30.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int arr[] = {37,12,28,9,100,56,80,5,12};
		System.out.println(Arrays.toString(arrayRankTransform(arr)));
	}

	public static int[] arrayRankTransform(int[] arr) {
		TreeMap<Integer, Integer> map = new TreeMap<> ();

		for(int x : arr) {
			map.put(x, 0);
		}

		int rank = 1;
		for(Map.Entry element : map.entrySet()) {
			map.put((Integer)element.getKey(), (Integer)rank);
			rank += 1;
		}

		for(int i=0; i<arr.length; i++) {
			arr[i] = map.get(arr[i]);
		}

		return arr;
    }
}