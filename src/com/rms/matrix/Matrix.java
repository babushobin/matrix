package com.rms.matrix;

/***
 * 
 * @author Babu Shobin Jose
 * Class for finding max product of x consecutive integers from a grid
 */
public class Matrix {

	private static final long DEFAULT_PRODUCT = Long.MIN_VALUE;
	 int counter;
	/**
	 * Finds out the greatest product of x adjacent number in up , down or diagonal
	 * direction.
	 * 
	 * @param grid   - 2D Array
	 * @param length - x the number of adjacent numbers in the same direction.
	 * @return - Greatest product, return Long.MIN_VALUE, if unable to find minimum.
	 */
	public long findProduct(int[][] grid, int length) {
		// rowSize
		int rowSize = 0;
		// columnSize;
		int columnSize = 0;
		long result = 0;
		counter=0;
		// Assuming the grid can contain both positive and negative integers.
		long max = Long.MIN_VALUE;
		// Checking for boundary conditions, if it cannot calculate length size of
		// Consecutive numbers
		// then return default value as zero.
	
		if ((grid==null)||(grid.length < length && grid[0].length < length)) {
			return DEFAULT_PRODUCT;
		}

		rowSize = grid.length;
		columnSize = grid[0].length;

		// Start Scanning.
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				// Scan horizontal
				if (j - length+1 >= 0) {
					result = getHorizontalProduct(grid, length, i, j);
					max = compare(result, max);
				}
				
				// Scan vertical
				if (i - length + 1 >= 0) {
					result = getVerticalProduct(grid, length, i, j);
					max = compare(result, max);
				}
				
				// Scan Left diagonal 
				if (i - length + 1 >= 0 && j - length + 1 >= 0) {
					result = getLeftDiagonalProduct(grid, length, i, j);
					max = compare(result, max);
				}
				
				// Scan Right Diagonal

				if (i - length +1 >= 0 && j + length-1 < columnSize) {
					result = getRightDiagonalProduct(grid, length, i, j);
					max = compare(result, max);
				}
				
			}
		}

		return max;
	}

	/***
	 * Compare and assign largest result
	 * 
	 * @param result
	 * @param max
	 * @return
	 */
	private long compare(long result, long max) {
		counter++;
		if (result > max) {
			max = result;
		}
		return max;
	}

	/***
	 * Calculate product of vertical
	 * 
	 * @param grid
	 * @param length
	 * @param i      row position
	 * @param j      column position
	 * @return product of consecutive number in vertical
	 */
	private long getVerticalProduct(int[][] grid, int length, int i, int j) {
		long result = 1;
		for (int k = 0; k < length; k++) {
			result *= grid[i - k][j];
		}
		return result;
	}

	/***
	 * Calculate product of horizontal
	 * 
	 * @param grid
	 * @param length
	 * @param i      row position
	 * @param j      column position
	 * @return product of consecutive number in horizontal
	 */
	private long getHorizontalProduct(int[][] grid, int length, int i, int j) {
		long result = 1;
		for (int k = 0; k < length; k++) {
			result *= grid[i][j - k];
		}
		return result;
	}

	/***
	 * Calculate product of left diagonal
	 * 
	 * @param grid
	 * @param length
	 * @param i      row position
	 * @param j      column position
	 * @return product of consecutive number in left diagonal
	 */
	private long getLeftDiagonalProduct(int[][] grid, int length, int i, int j) {
		long result = 1;
		for (int k = 0; k < length; k++) {
			result *= grid[i - k][j - k];
		}
		return result;
	}

	/***
	 * Calculate product of Right diagonal
	 * 
	 * @param grid
	 * @param length
	 * @param i      row position
	 * @param j      column position
	 * @return  product of consecutive number in right diagonal
	 */
	private long getRightDiagonalProduct(int[][] grid, int length, int i, int j) {
		long result = 1;
		for (int k = 0; k < length; k++) {
			result *= grid[i - k][j + k];
		}
		return result;
	}

	public static void main(String[] args) {
		Matrix m = new Matrix();
		
		  int grid[][] = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75}, {49, 49, 99, 40, 17,
		  81, 18, 57, 60, 87}, {81, 49, 31, 73, 55, 79, 14, 29, 93, 71}, {52, 70, 95,
		  23, 4, 60, 11, 42, 69, 24}, {22, 31, 16, 71, 51, 67, 63, 89, 41, 92}, {24,
		  47, 32, 60, 99, 3, 45, 2, 44, 75}, {32, 98, 81, 28, 64, 23, 67, 10, 26, 38},
		  {67, 26, 20, 68, 2, 62, 12, 20, 95, 63}, {24, 55, 58, 5, 66, 73, 99, 26, 97,
		  17}, {21, 36, 23, 9, 75, 0, 76, 44, 20, 45}};
		 
		
		long result = m.findProduct(grid, 3);
		System.out.println("Number of combinations:"+m.counter);
		System.out.println(result);
	}

}