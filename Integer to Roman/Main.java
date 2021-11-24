// Integer to Roman; complete: Y
// date: 03.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		// ip-1
		// int num = 3;
		// String AC = "III";

		// ip-2
		// int num = 4;
		// String AC = "IV";

		// ip-3
		// int num = 9;
		// String AC = "IX";

		// ip-4
		// int num = 58;
		// String AC = "LVIII";

		// ip-5
		// int num = 1994;
		// String AC = "MCMXCIV";

		// ip-6
		// int num = 2021;
		// String AC = "MMXXI";

		// ip-7
		// int num = 729;
		// String AC = "DCCXXIX";

		// ip-8
		int num = 821;
		String AC = "DCCCXXI";

		String result = intToRoman(num);

		System.out.println(result +"\t"+ AC.equals(result));
	}

	public static String intToRoman(int num) {
		int n = num;
		String r = "";
		while(n != 0) {
			if(n >= 1 && n <= 3) {
				n -= 1;
				r += "I";
			}
			else if(n == 4) {
				n -= 4;
				r += "IV";
			}
			else if(n >= 5 && n <= 8) {
				n -= 5;
				r += "V";
			}
			else if(n == 9) {
				n -= 9;
				r += "IX";
			}
			else if(n >= 10 && n <= 39) {
				n -= 10;
				r += "X";
			}
			else if(n >= 40 && n <= 49) {
				n -= 40;
				r += "XL";
			}
			else if(n >= 50 && n <= 89) {
				n -= 50;
				r += "L";
			} 
			else if(n >= 90 && n <= 99) {
				n -= 90;
				r += "XC";
			}
			else if(n >= 100 && n <= 399) {
				n -= 100;
				r += "C";
			} 
			else if(n >= 400 && n <= 499) {
				n -= 400;
				r += "CD";
			}
			else if(n >= 500 && n <= 899) {
				n -= 500;
				r += "D";
			}
			else if(n >= 900 && n <= 999) {
				n -= 900;
				r += "CM";
			}
			else {
				n -= 1000;
				r += "M";
			}
		}

		return r;
	}
}