/*
 * Name: Cade M Forbes
 * Email: cforb19@lsu.edu
 * Project: PA-1 (Multithreading)
 * Instructor: Feng Chen
 * Class: cs4103-sp21
 * LoginID: cs410332
 */

import java.util.Scanner;

public class Multithreading {

	private static int posIntRequest(String inputPrompt) {	
		int number;
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
			
			if(inputPrompt != null)
				System.out.println(inputPrompt);
			
			if (in.hasNextInt()) {
				number = in.nextInt();
				in.nextLine();
				if (number <= 0) {
					System.out.println("Value must not be less than 1.");
					System.out.println();
				}
				else {
					return number;
					}
				}
			else {
				System.out.println("Value must be a number.");
				System.out.println();
				in.nextLine();
			}
		}
	}
	
	
	private static int intRequest(String inputPrompt) {	
		int number;
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
			
			if(inputPrompt != null)
				System.out.println(inputPrompt);
			
			if (in.hasNextInt()) {
				number = in.nextInt();
				in.nextLine();
				return number;
				}
			else {
				System.out.println("Value must be a number.");
				System.out.println();
				in.nextLine();
			}
		}
	}
	
	
	
	public static void main(String[] args) {

		  int m1Rows;
		  int m1Cols;
		  int m2Rows;
		  int m2Cols;
		  
		  //Obtain Matrix Parameters and Create Matrices
		  m1Rows = posIntRequest("Enter amount of Rows in Matrix 1: ");
		  m1Cols = posIntRequest("Enter amount of Columns in Matrix 1: ");
		  
		  m2Rows = posIntRequest("Enter amount of Rows in Matrix 2: ");
		  m2Cols = posIntRequest("Enter amount of Columns in Matrix 2: ");
		  
		  int[][] matrix1 = new int[m1Rows][m1Cols];
		  int[][] matrix2 = new int[m2Rows][m2Cols];
		  
		  
		  
		  
		  //Obtain Matrix 1 values
		  System.out.println();
		  System.out.println("Enter the values of each row in Matrix 1 from left to right starting from the top: ");
		  System.out.println("(Press 'Enter' after each entry)");
		  
		  for(int i = 0; i < matrix1.length; i ++) {
			  for(int j = 0; j < matrix1[0].length; j++) {
				  matrix1[i][j] = intRequest(null);
			  }
		  }
		  
		  
		  
		  
		  //Obtain Matrix 2 values
		  System.out.println();
		  System.out.println("Enter the values of each row in Matrix 2 from left to right starting from the top: ");
		  System.out.println("(Press 'Enter' after each entry)");
		  
		  for(int i = 0; i < matrix2.length; i ++) {
			  for(int j = 0; j < matrix2[0].length; j++) {
				  matrix2[i][j] = intRequest(null);
			  }
		  }
		  
		  
		  
		  
		  

		  int[][] result = new int[matrix1.length][matrix2[0].length];
		  long start = System.currentTimeMillis();
		  ParallelThreads.multiply(matrix1, matrix2, result);
		  long elapsed = System.currentTimeMillis() - start;
		  
		  System.out.println();
		  System.out.println("Result of Matrix Multiplication is:"); 
          for (int i = 0; i < result.length; i++) { 
              for (int j = 0; j < result[0].length; j++) 
                  System.out.print(result[i][j] + "  "); 
              System.out.println(); 
          } 
          
          System.out.println();
          System.out.println("Time Elapsed: " + elapsed + "ms");
		  

		 

	}

}
