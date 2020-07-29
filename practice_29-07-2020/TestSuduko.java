
/**
 *2.	Sudoku is a mathematical puzzle based on a 9 x 9 matrix. 
 *This matrix is subdivided into 3 x 3 submatrices. The aim of the
 *game is to complete a partial filled matrix with numbers from 
 *1 to 9 such that every number occurs exactly once in every row,
 *column und 3 x 3 submatrix. With backtracking all combinations
 *can be systematically found.
 *
 *To decide efficiently whether a new number is allowed to place in a field,
 *you should think of an data structure with which for a given row r and 
 *column c the nubmer z can be placed into the field or not. This data 
 *structure is similiar to the one used for the eight queens problem.

 * 
 * @author (Me😊) 
 * @version (a version number or a date)
 */
// class Sudoku{
//     //pass
// }
public class TestSudoku {
    
    public static int[][] grid;

	public boolean solveSUDOKU() {
		int row;
		int col;
		int[] blankCell = findBlankLocation();
		row = blankCell[0];
		col = blankCell[1];
		if (row == -1) {
			// means will have filled the grid, return;
			return true;
		}
		// we need to fill grid[row][col] cell
		for (int i = 1; i <= 9; i++) {
			// check if number i is safe for grid[row][col] cell
			if (isSafe(row, col, i)) {
				// means its safe to fill the number
				grid[row][col] = i;
				// fill the rest of the grid
				if (solveSUDOKU()) {
					return true;
				}
				// if we are here that means current selection of number didnt
				// work, revert back the changes
				grid[row][col] = 0;
			}
		}
		return false; // This will cause the backtracking
	}

	public boolean isSafe(int row, int col, int n) {
		// we need to check row contains number n OR
		// Column contains number n OR
		// Block in which cell appears contains number n
		// If Any of the above statement is true, return false
		if (!UsedInRow(row, n) && !UsedInColumn(col, n)
				&& !UsedInBox(row - row % 3, col - col % 3, n)) {
			return true;
		}
		return false;
	}

	// check if n not in particular row
	public boolean UsedInRow(int row, int n) {
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == n) {
				return true;
			}
		}
		return false;
	}

	// check if n not in particular column
	public boolean UsedInColumn(int col, int n) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == n) {
				return true;
			}
		}
		return false;
	}

	// check if n not in particular box
	public boolean UsedInBox(int boxStartRow, int boxStartCol, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + boxStartRow][j + boxStartCol] == n) {
					return true;
				}
			}
		}
		return false;
	}

	public int[] findBlankLocation() {
		int[] cell = new int[2]; // cell[0]-row cell[1] -column
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					cell[0] = i;
					cell[1] = j;
					return cell;
				}
			}
		}
		cell[0] = -1;
		cell[1] = -1;
		return cell; // means grid is full
	}

	public void print() {
		for (int row = 0; row < 9; row++) {
			if (row % 3 == 0) {
				System.out.println(); // for more readability
			}
			for (int col = 0; col < 9; col++) {
				if (col % 3 == 0) {
					System.out.print(" "); // for more readability
				}
				System.out.print(grid[row][col] + " ");

			}
			System.out.println();
		}
	}

	

    
    public static void main(String[] args) {
		grid = new int[][] { 
                            { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				            { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
                            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				            { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
                            { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				            { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, 
                            { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				            { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
                            { 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
                          };
		TestSudoku s = new TestSudoku();
		if (s.solveSUDOKU()) {
			s.print();
		} else {
			System.out.println("NO SOLUTION");
		}
	}
}
