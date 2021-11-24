// String to Integer (atoi); complete: y
// date: 27.10.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		String s= "  0000000000012345678";
		int AC = 12345678;

		int result = myAtoi(s);

		System.out.println(result +"\t"+(AC == result));
	}

	public static int myAtoi(String s) {

		int Max_Value = (int)Math.pow(2, 31);
		int Min_Value = (int)Math.pow(-2, 31);

		boolean flag = true;
		int i = 0, loc;

		s = s.trim();
		if(s.length() == 0) return 0;

		if(s.charAt(i) == '-') {
			flag = false;
			i += 1;
		}
		else if(s.charAt(i) == '+') {
			flag = true;
			i += 1;
		}


		while(i < s.length()) {
			if(s.charAt(i) != '0') break;
			i += 1;
		}

		loc = i;
		while(i<s.length()) {

			if(s.charAt(i) < '0' || s.charAt(i) > '9') break;

			i += 1;
		}

		s = s.substring(loc, i);
		System.out.println(s);
		if(s.length() > 0) {

			if(s.length() <= 11) {
				long temp = Long.parseLong(s);				
				if(flag == false) temp *= (-1);

				if(temp >= (long)Max_Value) {
					return Max_Value;
				}
				else if(temp <= (long)Min_Value) {
					return Min_Value;
				}
				else {
					return (int) temp;
				}
			}
			else {
				if(flag == false) return Min_Value;
				else return Max_Value;
			}





		}

		return 0;
	}
}