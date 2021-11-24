// Regular Expression Matching; Complete: n
// date: 02.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		String s, p;

		s = "aaa";
		p = "a*a";

		boolean AC = true;

		boolean result = isMatch(s, p);
		System.out.println(result +"\t"+ (AC == result));

	}

	// public static boolean isMatch(String s, String p) {
	// 	char ch, nch;

	// 	int i = 0;
	// 	int j = 0;
	// 	while(i < p.length()) {
	// 		ch = p.charAt(i);

	// 		nch = '#';
	// 		if(i+1 < p.length()) {
	// 			nch = p.charAt(i+1);
	// 		}

	// 		System.out.println("ch: "+ch+"\tnch: "+nch);
	// 		if(ch == '.') {
	// 			System.out.println("ch == '.'");
	// 			if(nch == '*') {
	// 				j = s.length();
	// 				i += 2;
	// 				break;
	// 			}
	// 			j += 1;
	// 			i += 1;
	// 		}
	// 		else if(ch >= 'a' && ch <= 'z') {
	// 			System.out.println("\tch == '" + ch + "'");				
	// 			if(nch == '*') {
	// 				while(j < s.length()) {
	// 					if(s.charAt(j) == ch)
	// 						j += 1;
	// 					else break;
	// 				}
	// 				i += 2;
	// 			}
	// 			else {
	// 				if(s.charAt(j) != ch) return false;
	// 				else {
	// 					i += 1;
	// 					j += 1;
	// 				}
	// 			}
	// 		}
	// 	}

	// 	System.out.println("i: "+i+"\tj: "+j);
	// 	if(i == p.length() && j == s.length()) return true;
	// 	else return false;
	// }

	public static boolean isMatch(String s, String p) {

		Stack<>
		char ch, nch;

		int	i = p.length()-1;
		int j = s.length()-1;
		while(i >= 0) {
			ch = p.charAt(i);
			i -= 1;

			// if the current element is '*'; this is a special case
			if(ch == '*') {
				// get the its previous element
				nch = p.charAt(i);
				if(nch == '.') {
					j = 0;
				}
				i -= 1;
			}

			// if the current element is not a '*'
			else {
				// if the current element is '.'
				if(ch == '.') {
					j -= 1;
				}

				// if the current element between a - z
				else {
					if(s.charAt(j) != ch) return false;
					else j -= 1;
				}
			}

		}
	}
}