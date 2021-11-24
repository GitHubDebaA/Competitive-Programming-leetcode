// Letter Combinations of a Phone Number; complete: y
// date: 03.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		String digits = "";	
		System.out.println(letterCombination(digits));
		System.out.println("length: "+letterCombination(digits).size());
	}

	public static List<String> letterCombination(String digits) {

		ArrayList<List<String>> aList = new ArrayList<List<String>>();
		List<String> l1 = new ArrayList<String>();
		List<String> l2;

		if(digits.length() == 0) return l1;
		l1.add("");
		aList.add(l1);

		for(int i=0; i<digits.length(); i++) {
			int x = digits.charAt(i) - '0';
			String s = mappedDigits(x);
			// System.out.println("s: "+s);
			l1 = aList.get(i);
			// System.out.println("list for s: "+l1);
			l2 = new ArrayList<String>();
			for(int j=0; j<s.length(); j++) {
				String t1 = s.substring(j, j+1);
				for(int k=0; k<l1.size(); k++) {
					String t2 = l1.get(k);
					t2 = t2 + t1;
					l2.add(t2);
				}
			}

			aList.add(l2);
		}
		return aList.get(aList.size()-1);
	}

	public static String mappedDigits(int x) {
		String s = "";
		switch (x) {
			case 2:
					s = "abc";
					break;
			case 3: 
					s = "def";
					break;
			case 4: 
					s = "ghi";
					break;
			case 5:
					s = "jkl";
					break;
			case 6:
					s = "mno";
					break;
			case 7:
					s = "pqrs";
					break;
			case 8:
					s = "tuv";
					break;
			case 9:
					s = "wxyz";
					break;
			default:
					s = "Tu Pagal Hai Kya!!";
		}
		return s;
	}
}

