// ZigZag Conversion; complete : y
// date: 23.10.2021

import java.util.*;

class Main{
	public static void main(String args[]) {
		// String s = "PAYPALISHIRING";
		// int numRows = 4;
		// String answer = "PINALSIGYAHRPI";

		// String s = "PAYPALISHIRING";
		// int numRows = 3;
		// String answer = "PAHNAPLSIIGYIR";

		String s = "A";
		int numRows = 1;
		String answer = "A";

		String result = convert(s, numRows);
		System.out.println(result +"\t"+ (answer.equals(result)));

	}

	public static String convert(String s, int numRows) {

		if(numRows == 1) return s;

		int v = numRows - 1;
		int z = v - 1;

		String S1 = "", S2 = "", S3 = "";	

		int i = 0, j, loc;

		while(i < s.length()) {
			if(i+1 <= s.length()) {
				S1 += s.substring(i, i+1);
				i += 1;
			}
			else{
				S1 += s.substring(i);
				i = s.length();
				break;
			}

			if(i+v <= s.length()) {
				S2 += s.substring(i, i+v);
				i += v;				
			}
			else{
				S2 += s.substring(i);
				i = s.length();
				break;
			}


			if(i+z <= s.length()) {
				S3 += s.substring(i, i+z);
				i += z;				
			}
			else{
				S3 += s.substring(i);
				i = s.length();
				break;
			}
		}

		// System.out.println("s2: "+S2+"\t"+"s3: "+S3);

		i = 0;
		j = z-1;
		s = "";
		while(i < v || j >= 0) {
			String t1, t2, t;

			loc = i;
			t1 = "";
			while(loc < S2.length()) {
				t1 += S2.substring(loc, loc+1);
				loc += v;
			}
			
			t2 = "";			
			if(j >= 0) {
				loc = j;
				while(loc < S3.length()) {
					// System.out.println("loc: "+loc+"\ts3.length: "+S3.length()+"\tz: " +z);
					t2 += S3.substring(loc, loc+1);
					loc += z;
				}				
			}


			loc = 0;
			t = "";
			while(loc < t1.length()) {
				t += t1.substring(loc, loc+1);

				if(loc < t2.length()) {
					t += t2.substring(loc, loc+1);
				}

				loc += 1;
			}
			s += t;
			i += 1;
			j -= 1;
		}
		return S1 + s;
	}

}
