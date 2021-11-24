// Integer to English words; complete: y
// date: 03.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		// ip-1
		// int num = 2147483647;
		// String AC = "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven";

		// ip-2
		// int num = 4;
		// String AC = "Four";

		// ip-3
		// int num = 123;
		// String AC = "One Hundred Twenty Three";

		// ip-4
		// int num = 12345;
		// String AC = "Twelve Thousand Three Hundred Forty Five";

		// ip-5
		// int num = 1994;
		// String AC = "One Thousand Nine Hundred Ninety Four";

		// ip-6
		// int num = 2021;
		// String AC = "Two Thousand Twenty One";

		// ip-7
		// int num = 729;
		// String AC = "Seven Hundred Twenty Nine";

		// ip-8
		// int num = 801;
		// String AC = "Eight Hundred One";

		// ip-9
		// int num = 1234567;
		// String AC = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";

		// ip-10
		// int num = 1234567891;
		// String AC = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";

		// ip-11
		// int num = 1000;
		// String AC = "One Thousand";

		// ip-12
		// int num = 000000000;
		// String AC = "Zero";

		// ip-13
		// int num = 10000000;
		// String AC = "Ten Million";

		// ip-14;
		// int num = 20;
		// String AC = "Twenty";

		// ip-15
		// int num = 120120;
		// String AC = "One Hundred Twenty Thousand One Hundred Twenty";

		// ip-16
		// int num = 100;
		// String AC = "One Hundred";

		// ip-17
		int num = 1000010;
		String AC = "One Million Ten";

		String result = numberToWords(num);

		System.out.println(result +"\t"+ AC.equals(result));		
	}

	public static String numberToWords(int num) {
		if(num == 0) return "Zero";

		String r = "";
		String n = Integer.toString(num);
		int len = n.length();
		int count = len/3;
		if(len % 3 != 0) count += 1;

		int loc = len, i = 1; 

		String s = "";
		while(i <= count) {
			if(i == count) {
				s = n;
				n = "";
			}
			else {
				s = n.substring(len-3);
				n = n.substring(0, len-3);
			}
			len = len - 3;

			String newS = shortScale(s);
	
			if(newS.length() != 0) {
				if(i == 2) r = "Thousand " + r;
				if(i == 3) r = "Million " + r;
				if(i == 4) r = "Billion " + r;				
			}			

			s = shortScale(s);
			if(s.length() != 0) {
				r = s +" "+ r;
			}
			i += 1;
		}
		return r.trim();
	}

	public static String shortScale(String s) {

		int len = s.length();

		if(len == 1) {
			if(s.equals("0")) return "";
			return shortScaletoWords(Integer.parseInt(s));
		}
		if(len == 2) {
			if(s.equals("00")) return "";
			if(s.charAt(0) == '1' || s.charAt(0) == '0') {
				return shortScaletoWords(Integer.parseInt(s));
			}
			else {
				int x = s.charAt(0) - '0';
				x = x * 10;
				int y = s.charAt(1) - '0';
				if(y != 0) 
					return shortScaletoWords(x) + " " + shortScaletoWords(y);
				else return shortScaletoWords(x);
			}
		}
		if(len == 3) {
			if(s.equals("000")) return "";
			int z = s.charAt(0) - '0';
			String pre = "";
			if(z != 0) {
				pre = shortScaletoWords(z) + " Hundred";
			}
			if(s.charAt(1) == '1' || s.charAt(1) == '0') {
				if(s.substring(1).equals("00")) return pre + "";

				return (pre +" "+ shortScaletoWords(Integer.parseInt(s.substring(1)))).trim();
			}
			else {
				int x = s.charAt(1) - '0';
				x = x * 10;
				int y = s.charAt(2) - '0';
				if(y != 0) 
					return (pre +" "+ shortScaletoWords(x) + " " + shortScaletoWords(y)).trim();
				else return (pre +" "+ shortScaletoWords(x)).trim();
			}	
		}
		return "";
	}

	public static String shortScaletoWords(int x) {
		String r = "";
		switch(x) {
			case 0:
					r = "Zero";
					break;
			case 1: 
					r = "One";					
					break;
			case 2: 
					r = "Two";
					break;
			case 3: 
					r = "Three";
					break;
			case 4: 
					r = "Four";					
					break;
			case 5: 
					r = "Five";
					break;
			case 6: 
					r = "Six";
					break;
			case 7: 
					r = "Seven";
					break;
			case 8: 
					r = "Eight";
					break;
			case 9: 
					r = "Nine";
					break;
			case 10: 
					r = "Ten";
					break;
			case 11: 
					r = "Eleven";
					break;
			case 12: 
					r = "Twelve";
					break;
			case 13: 
					r = "Thirteen";
					break;
			case 14: 
					r = "Fourteen";
					break;
			case 15: 
					r = "Fifteen";
					break;
			case 16: 
					r = "Sixteen";
					break;					
			case 17: 
					r = "Seventeen";
					break;
			case 18: 
					r = "Eighteen";
					break;
			case 19: 
					r = "Nineteen";
					break;
			case 20: 
					r = "Twenty";
					break;
			case 30: 
					r = "Thirty";
					break;
			case 40: 
					r = "Forty";
					break;
			case 50: 
					r = "Fifty";
					break;
			case 60: 
					r = "Sixty";
					break;
			case 70: 
					r = "Seventy";
					break;
			case 80: 
					r = "Eighty";
					break;
			case 90: 
					r = "Ninety";
					break;
			default :
					r = "Ye kya de diya be BSDK!!!";
		}

		return r;
	}

}
