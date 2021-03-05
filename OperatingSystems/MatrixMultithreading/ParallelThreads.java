/*
 * Name: Cade M Forbes
 * Email: cforb19@lsu.edu
 * Project: PA-1 (Multithreading)
 * Instructor: Feng Chen
 * Class: cs4103-sp21
 * LoginID: cs410332
 */


import java.util.ArrayList;
import java.util.List;


public class ParallelThreads {
	
	public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result) {
		List threads = new ArrayList<>();
		int rows = matrix1.length;
		
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < matrix2[0].length; j++) {
				result[i][j] = 0;
				RowMultiply task = new RowMultiply(result, matrix1, matrix2, i, j);
				Thread thread = new Thread(task);
				thread.start();
				threads.add(thread);
				
				if(threads.size() % (matrix1.length*matrix2[0].length) == 0) {
					waitForThreads(threads);
				}
				
			}
			
		}
	}
	
	private static void waitForThreads(List<Thread> threads) {
		for(Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		threads.clear();
	}
}
