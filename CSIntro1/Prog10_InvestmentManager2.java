/**
 * This program performs analysis on investments and generates reports
 * to provide the status of their performance.
 * 
 * CSC 1350 Programming project No 10
 * Section 1
 * 
 * @author Cade M Forbes
 * @since 4/24/2020
 * 
 */

import java.util.Scanner;
public class Prog10_InvestmentManager2 {

	/**
	 * This Method PROMPTS for number of investors and investments and creates a matrix.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static int[][] MatrixRequest() {
		Scanner in = new Scanner(System.in);
		
		int numInvestors;  		//NUMBER OF INVESTORS
		int numInvestments; 	//NUMBER OF INVESTMENTS
		
		
		
		//INPUT REQUEST AND VALIDATION for investors
		do {
			System.out.println("Enter number of investors:");
			if (in.hasNextInt()) {
				numInvestors = in.nextInt();
				in.nextLine();
				if (numInvestors < 0) {
					System.out.println("ERROR: Must be a positive integer.");
					System.out.println();
				}
				else {
					break;
				}
			}
			else {
				System.out.println("ERROR: Must be a positive integer");
				System.out.println();
				in.nextLine();
			}
		}
		while (true);
		
		
		//INPUT REQUEST AND VALIDATION for number of investments
		do {
			System.out.println("Enter number of investments:");
			if (in.hasNextInt()) {
				numInvestments = in.nextInt();
				in.nextLine();
				if (numInvestments < 0) {
					System.out.println("ERROR: Must be a positive integer.");
					System.out.println();
				}
				else {
					break;
				}
			}
			else {
				System.out.println("ERROR: Must be a positive integer");
				System.out.println();
				in.nextLine();
			}
		}
		while (true);
		
		
		
		//CREATING ARRAY ("+ 1" accounts for the extra column for Investor IDs)
		int[][] investPort = new int[numInvestors][numInvestments + 1];
		
		//RETURNING ARRAY
		return investPort;
	}

	/**
	 * This Method PROMPTS for Investor IDs and investment values to fill a matrix with.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static int[][] InvestmentList(int[][] investPort) {
		Scanner in = new Scanner(System.in);
		
		//LOOP FOR INPUT REQUEST AND VALIDATION for Investor ID and Investment Amounts
		for (int i = 0; i < investPort.length; i++) {
			
			do {
				System.out.println("Enter investor ID:");
				if (in.hasNextInt()) {
					investPort[i][0] = in.nextInt();
					in.nextLine();
					if (investPort[i][0] < 0) {
						System.out.println("ERROR: Must be a positive integer.");
						System.out.println();
					}
					else {
						System.out.println();
						break;
					}
				}
				else {
					System.out.println("ERROR: Must be a positive integer");
					System.out.println();
					in.nextLine();
				}
			}
			while (true);
			
			
			//LOOP FOR INPUT REQUEST AND VALIDATION for Investment Amounts
			for (int j = 1; j < investPort[0].length; j++) {
			do {
				System.out.println("Enter investment amount:");
				if (in.hasNextInt()) {
					investPort[i][j] = in.nextInt();
					in.nextLine();
					if (investPort[i][j] < 0) {
						System.out.println("ERROR: Must be a positive integer.");
						System.out.println();
					}
					else {
						System.out.println();
						break;
					}
				}
				else {
					System.out.println("ERROR: Must be a positive integer");
					System.out.println();
					in.nextLine();
				}
			}
			while (true);
			}
		}
		
		//RETURNING ARRAY WITH NEW VALUES
		return investPort;
	}
	
	/**
	 * This Method SWAPS elements within a given matrix.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static int[][] ElSwap(int[][] investPort, int i, int j, int k) {
		//DECLARING A PLACEHOLDER VARIABLE FOR SWAPPING ELEMENTS OF A MATRIX
		int temp = investPort[i][j];
		
		//SWAPPING MATRIX ELEMENTS
		investPort[i][j] = investPort[i][k];
		investPort[i][k] = temp;
		
		//RETURN MATRIX WITH SWAPPED ELEMENTS
		return investPort;
	}
	
	/**
	 * This Method SORTS the elements within a given matrix.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static int[][] MatrixSort(int[][] investPort) {

		
		//LOOP FOR EACH ROW
		for (int i = 0; i < investPort.length; i++) {
			boolean sorted = false;  //DECLARING AND INITIALIZING VARIABLE FOR SHORTCUT
			int j = 1; 				 //DECLARING AND INITIALIZING VARIABLE FOR INDEX
			
			
			
			//LOOP TEESTING FOR EACH PAIR WITHIN A ROW (SHORTCUT FOR BUBBLESORT)
			while (!sorted) {
				if (j == investPort[0].length) {
					sorted = true;
				}
				else {
					sorted = true;
					
					for (int k = 1; k < investPort[0].length - j; k++) {
						if (investPort[i][k] > investPort[i][k+1]) {
							investPort = ElSwap(investPort, i, k, k + 1);
							sorted = false;
						}
					}
				}
				j++;
			}
		}
		
		//RETURN NEW SORTED MATRIX
		return investPort;
		
	}
	
	/**
	 * This Method FINDS the MINIMUM VALUE within a given sorted matrix.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static int FindMin(int[][] sortedMatrix) {
		int min = sortedMatrix[0][1];	//DECLARING AND INITIALIZING A MINIMUM VALUE
		
		//LOOP TO ITERATE THOUGH EACH ROW
		for (int i = 1; i < sortedMatrix.length; i++) {
			
			//COMPARISON OF EACH VALUE IN THE DECIDED COLUMN
			if (min > sortedMatrix[i][1]) {
				min = sortedMatrix[i][1];
			}
		}
		
		//RETURN MINIMUM VALUE
		return min;
	}
	
	/**
	 * This Method FINDS the MAXIMUM VALUE within a given sorted matrix.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static int FindMax(int[][] sortedMatrix) {
		int col = sortedMatrix[0].length - 1;	//SETTING COLUMN POSITION FOR COMPARISON
		int max = sortedMatrix[0][col];			//DECLARING AND INITIALIZING A MAXIMUM VALUE
		
		//LOOP TO ITERATE THOUGH EACH ROW
		for (int i = 1; i < sortedMatrix.length; i++) {
			
			//COMPARISON OF EACH VALUE IN THE DECIDED COLUMN
			if (max < sortedMatrix[i][col]) {
				max = sortedMatrix[i][col];
			}
		}
		
		//RETURN MAXIMUM VALUE
		return max;
	}
	
	/**
	 * This Method PRINTS a given matrix with borders and separators.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020 
	 * 
	 */
	public static void PrintMatrix(int[][] someMatrix) {
		
		//PRINTING TOP EDGE
		System.out.print("-");
		for (int i = 0; i < someMatrix[0].length; i++) {
			System.out.print("-------------");
		}
		System.out.println();
		
		//PRINTING EACH ELELMENT BY ROW AND COLUMN WITH SEPARATORS
		for (int i = 0; i < someMatrix.length; i++) {
			
			System.out.print("|");
			for (int j = 0; j < someMatrix[0].length; j++) {
				System.out.printf("%11d |", someMatrix[i][j]);
			}
			System.out.println();
			
			//PRINTING ROW SEPARATORS
			System.out.print("-");
			for (int j = 0; j < someMatrix[0].length; j++) {
				System.out.print("-------------");
			}
			System.out.println();
			
		}
		
	}
	
	/**
	 * This Method PRINTS the given MINUMUM AND MAXIMUM values in a proper format.
	 * 
	 * CSC 1350 Programming Project No 10
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/24/2020
	 * 
	 */
	public static void PrintMinMax(int min, int max) {
		//PRINTING MINIMUM AND MAXIMUM VALUES
		System.out.printf("Minimum:   $%10d\n", min);
		System.out.printf("Maximum:   $%10d\n", max);
	}
	
	public static void main(String[] args) {
		
		int [][] investPort = MatrixRequest();					//PROMPTING USER AND INITIALIZING MATRIX
		
		investPort = InvestmentList(investPort);				//PROMPTING USER AND SETTING INVESTOR IDs AND INVESTMENT VALUES
		
		int [][] investPortSorted = MatrixSort(investPort);		//SORTING MATRIX OF INVESTOR INFO
		
		int min = FindMin(investPortSorted);					//FINDING MINIMUM OF SORTED INVESTOR INFO
		
		int max = FindMax(investPortSorted);					//FINDING MAXIMUM OF SORTED INVESTOR INFO
		
	
		PrintMatrix(investPortSorted);							//PRINTING INVESTOR INFO IN FORMATTED FASHION
		
		System.out.println();									//SPACING FOR NEXT PRINT
		System.out.println();
		
		PrintMinMax(min, max);									//PRINTING MINIMUM AND MAXIMUM VALUES IN FORMATTED FASHION


	}

}