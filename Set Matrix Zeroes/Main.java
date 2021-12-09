// Set Matrix Zeroes; complete: y
// date: 09.11.2021

import java.util.*;

class Main {
	int matrix[][] = {};		
	public static void main(String[] args) {
		solution();
	}

	public static void solution() {
		HashMap<Integer, Integer> rows = new HashMap<> ();
        HashMap<Integer, Integer> cols = new HashMap<> ();
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(!rows.containsKey(i)) rows.put(i, 0);
                    if(!cols.containsKey(j)) cols.put(j, 0);
                }
            }
        }
        
        for(Map.Entry row : rows.entrySet()) {
            int x = (int)row.getKey();
            for(int i=0; i<matrix[0].length; i++) {
                matrix[x][i] = 0;
            }
        }

        for(Map.Entry col : cols.entrySet()) {
            int x = (int)col.getKey();

            for(int i=0; i<matrix.length; i++) {
                matrix[i][x] = 0;
            }
        }  
	}
}