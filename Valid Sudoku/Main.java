// Valid Sudoku; complete : y
// date : 24.09.2021

import java.util.*;

class Main {
	public static void main(String args[]) {
		char board[][] = {{'5','3','.','.','7','.','.','.','.'}
						,{'6','.','.','1','9','5','.','.','.'}
						,{'.','9','8','.','.','.','.','6','.'}
						,{'8','.','.','.','6','.','.','.','3'}
						,{'4','.','.','8','.','3','.','.','1'}
						,{'7','.','.','.','2','.','.','.','6'}
						,{'.','6','.','.','.','.','2','8','.'}
						,{'.','.','.','4','1','9','.','.','5'}
						,{'.','.','.','.','8','.','.','7','9'}};

		// for(int i=0; i<board.length; i++) {
		// 	System.out.println(Arrays.toString(board[i]));
		// }

		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char board[][]) {
		int i, j, ii, jj, x, ix, jx;

		i = 0;
		while(i < 9) {
			int columnStatus[] = {0,0,0,0,0,0,0,0,0,0};
			int rowStatus[] = {0,0,0,0,0,0,0,0,0,0};
			int subBoxStatus[] = {0,0,0,0,0,0,0,0,0,0};

			j = 0;
			ii = 0;
			jj = 0;
			while(j < 9) {

				ix = i / 3;
				jx = i % 3;

				ii = (j / 3) + (ix * 3);
				jj = (j % 3) + (jx * 3);
				
				if(board[i][j] != '.') {
					x = board[i][j] - '0';
					if(rowStatus[x] == 0) rowStatus[x] = 1;
					else return false;
				}

				if(board[j][i] != '.') {
					x = board[j][i] - '0';
					if(columnStatus[x] == 0) columnStatus[x] = 1;
					else return false;
				}

				if(board[ii][jj] != '.') {
					x = board[ii][jj] - '0';
					if(subBoxStatus[x] == 0) subBoxStatus[x] = 1;
					else return false;
				}
				j += 1;
			}
			i += 1;
		}

		return true;	
	}
}
