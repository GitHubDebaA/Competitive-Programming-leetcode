// Decode XORed Array; complete : y
// date : 27.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int encoded[] = {6,2,7,3};
		int first = 4;

		System.out.println(Arrays.toString(decode(encoded, first)));
	}

	public static int[] decode(int encoded[], int first) {
		int arr[] = new int[encoded.length + 1];
		arr[0] = first;

		for(int i=0; i<encoded.length; i++) {
			arr[i+1] = encoded[i] ^ arr[i];
		}
		return arr;
	}
}