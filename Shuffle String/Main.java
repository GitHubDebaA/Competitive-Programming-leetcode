// Shuffle String; complete : y
// date : 27.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		String s = "codeleet";
		int indices[] = {4,5,6,7,0,2,1,3};
		System.out.println(restoreString(s, indices));
	}

	public static String restoreString(String s, int indices[]) {
		char RS [] = new char[s.length()];

		for(int i=0; i<s.length(); i++) {
			RS[indices[i]] = s.charAt(i);
		}

		s = new String(RS);
		return s;
	}
}