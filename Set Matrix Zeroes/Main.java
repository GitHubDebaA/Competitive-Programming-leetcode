// Set Matrix Zeroes; complete: y
// date: 09.11.2021

import java.util.*;

class Main {
	public static int matrix[][] = {{1, 2, 0, 4}, {5, 6, 7, 8}, {9, 0, 11, 12}, {13, 14, 15, 16}};		
	public static void main(String[] args) {
        System.out.println("Initial Matrix--");
        for(int[] A : matrix) {
            System.out.println(Arrays.toString(A));
        }
		solution();
        System.out.println("\n\nAfter operation: ");
        for(int[] A : matrix) {
            System.out.println(Arrays.toString(A));
        }
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