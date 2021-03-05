/*
 * Name: Cade M Forbes
 * Email: cforb19@lsu.edu
 * Project: PA-1 (Multithreading)
 * Instructor: Feng Chen
 * Class: cs4103-sp21
 * LoginID: cs410332
 */


public class RowMultiply implements Runnable{
	private final int[][] result;
	private int[][] matrix1;
	private int[][] matrix2;
	private final int row;
	private final int col;
	
	public RowMultiply(int[][] result, int[][] matrix1, int[][] matrix2, int row, int col) {
		this.result = result;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.row = row;
		this.col = col;
		
	}
	
	@Override
	public void run() {
		for(int j = 0; j < matrix1[row].length; j++) {
			result[row][col] += matrix1[row][j] * matrix2[j][col];
		}
	
	}
}
