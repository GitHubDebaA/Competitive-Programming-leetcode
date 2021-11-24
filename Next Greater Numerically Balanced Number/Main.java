 // Next Greater Numerically Balanced Number; complete: n
// date: 24.10.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		int n = 16407;
		int AC = 22333;
		Solution obj = new Solution();

		System.out.println(obj.nextBeautifulNumber(n) +"\t"+ (AC == obj.nextBeautifulNumber(n)));
		System.out.println(nextBeautifulNumber(n) +"\t"+ (AC == nextBeautifulNumber(n)));
	}

	public static int nextBeautifulNumber(int n) {
		String sn = Integer.toString(n);
		int nlength = sn.length();
		int mxBalanced = 0, r = 0, mnBalanced = 0;

		for(int i=0; i<nlength; i++) {
			mxBalanced *= 10;
			mxBalanced += nlength;

			mnBalanced *= 10;
			mnBalanced += 1;
		}

		if(n >= mxBalanced) {

			if(nlength == 1) r = 22; 
			else {
				r = 1;
				for(int i=0; i<nlength; i++) {
					r *= 10;
					r += nlength;
				}			
			}
		}
		else {
			String s = Integer.toString(mxBalanced-mnBalanced);
			char A[] = s.toCharArray();
			
			for(int i=0; i<A.length; i++) {
				char ch = A[i];
				A[i] = '1';
				String temp = new String(A);

				int x = Integer.parseInt(temp);
				if(x > n) {
					r = x;
					break;
				}
				A[i] = ch;
			}

			if(r == 0) r = mxBalanced;
		}

		return r;
    }
}

class Solution {
    int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
    
    boolean checkCount(int num){
        int[] arr2 = new int[10];
        while(num!=0){
            int rem = num%10;
            arr2[rem]++;
            num/=10;
        }
        
        for(int i=0;i<10;i++){
            if(arr2[i]!=0 && arr2[i]!=i){
                return false;
            }
        }
        
        return true;
    }
    public int nextBeautifulNumber(int n) {
        
        for(int i=n+1;i<100000001;i++){
            if(checkCount(i)){
                return i;
            }
        }
        return -1;
    }
}