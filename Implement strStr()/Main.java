// Implement strStr(); complete: y
// date: 03.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		String haystack = "a";
		String needle = "a";

		int AC = 0;
		int result = strStr(haystack, needle);
		System.out.println(result +"\t"+(AC == result));
	}

	public static int strStr(String haystack, String needle) {
		if(needle.length() == 0) return 0;
		int l1 = haystack.length();
		int l2 = needle.length();

		int i=0;
		while(i <= l1-l2) {
			String s = haystack.substring(i, i+l2);
			if(s.equals(needle)) return i;
			i += 1;
		}
		return -1;
	}
}