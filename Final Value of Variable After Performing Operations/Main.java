// Final Value of Variable After Performing Operations; complete : y
// date : 25.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		String operations[] = {"--X","X++","X++"};
		System.out.println(finalValueAfterOperations(operations));
	}

	public static int finalValueAfterOperations(String operations[]) {
		int x=0;
		for(int i=0; i<operations.length; i++) {
			x += operation(operations[i]);
		}
		return x;
	}

	public static int operation(String S) {
		if(S == "++X" || S == "X++") return 1;
		if(S == "--X" || S == "X--") return -1;
		else return 0;
	}
}