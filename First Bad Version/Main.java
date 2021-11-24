// First Bad Version; complete: y
// date: 04.11.2021

import java.util.*;

class Main {

	public static long badVersion;
	public static void main(String[] args) {
		long n = 2126753390;

		badVersion = 1702766719;

		// count = 158142501
		System.out.println(n+" "+badVersion);
		System.out.println(search(n));
	}

	public static boolean isBadVersion(int version) {
		if(version >= badVersion) return true;
		else return false;
	}

	public static int search(long n) {
		long lb = 1, ub = n;
		Scanner S = new Scanner(System.in);

		int c = 0;
		while(lb<=ub) {
			long mid = (lb+ub)/2;

			System.out.println("lb: "+lb+"\tub: "+ub+"\tmid: "+mid);
			if((isBadVersion((int) mid)) && (mid == 1 || !isBadVersion((int) (mid-1) ))) {
				System.out.println(c);
				return (int) mid;
			}		

			if(isBadVersion((int) mid)) ub = mid - 1;
			else {
				lb = mid + 1;
			}
			c += 1;
		} 

		System.out.println(c);
		return -1;
	}
}

/*
 input-1
 n = 5
 badVersion = 3
 extends : good, good, bad, bad, bad,
 		   1	 2	   3    4	 5

 input-2
 n = 1
 badVersion = 1
 extends : bad,
 		   1

input-3
n=10
badVersion = 1
extends: bad, bad, bad, bad, bad, bad, bad, bad, bad, bad 
		 1 	  2    3    4    5    6    7    8    9    10
	
*/