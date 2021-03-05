/**
 * This program performs analysis on investments and generates reports
 * to provide the status of their performance.
 * 
 * CSC 1350 Programming project No 9
 * Section 1
 * 
 * @author Cade M Forbes
 * @since 4/17/2020
 * 
 */

import java.util.Scanner;
public class Prog09_InvestmentManager {
	
	/**
	 * This Method prompts for number of investments and creates an array.
	 * 
	 * CSC 1350 Programming Project No 9
	 * Section 1
	 * 
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double[] arrayRequest() {
		Scanner in = new Scanner(System.in);
		
		int length;  //Length of array
		
		
		//INPUT REQUEST AND VALIDATION
		do {
			System.out.println("Enter number of investments:");
			if (in.hasNextInt()) {
				length = in.nextInt();
				in.nextLine();
				if (length < 0) {
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
		
		//CREATING ARRAY
		double[] investments = new double[length];
		
		//RETURNING ARRAY
		return investments;
	}

	/**
	 * This Method prompts the user for the length of the array for input and validates
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double[] investmentList(double[] investments) {
		Scanner in = new Scanner(System.in);
		
		//LOOP FOR INPUT REQUEST AND VALIDATION
		for (int i = 0; i < investments.length; i++) {
			do {
				System.out.println("Enter investment amount:");
				if (in.hasNextDouble()) {
					investments[i] = in.nextDouble();
					in.nextLine();
					if (investments[i] < 0) {
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
		
		//RETURNING ARRAY WITH NEW VALUES
		return investments;
	}
	
	/**
	 * This Method finds the smallest value in the given array.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double minimum(double[] investments) {
		double min = investments[0];  //Initializing a minimum from the array
		
		
		//Comparing each element from the array to find the minimum
		for (int i = 1; i < investments.length; i++) {
			if (investments[i] < min) {
				min = investments[i];
			}
		}
		
		//Returning minimum value
		return min;
	}
	
	/**
	 * This Method finds the largest value in the given array.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double maximum(double[] investments) {
		double max = investments[0]; //Initializing a maximum from the array
		
		
		//Comparing each element from the array to find the maximum
		for (int i = 1; i < investments.length; i++) {
			if (investments[i] > max) {
				max = investments[i];
			}
		}
		
		//Returning maximum value
		return max;
	}
	
	/**
	 * This Method finds the total of the given array.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double sum(double[] investments) {
		double total = 0;		//Initializing Total for array
		
		//Adding each element of the given array
		for (int i = 0; i < investments.length; i++) {
			total = total + investments[i];
		}
		
		//Return total value
		return total;
	}
	
	/**
	 * This Method finds the mean value of the given array.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double mean(double[] investments, double sum) {

		double avg = 0;			//Initializing Average for array
		

		//Calculating Average value
		if (investments.length > 0) {
			avg = sum / investments.length;
		}
		
		//Returning Average value
		return avg;
	}
	
	/**
	 * This Method finds the percentages of the given array and stores them into a new one.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static double[] percents(double[] investments, double sum) {
		
		final int percConvert = 100;						//Constant to convert percent from decimal form
		double[] perc = new double[investments.length];		//New array to hold percentage values
		
		//Calculating and placing percentage values
		for (int i = 0; i < investments.length; i++) {
			perc[i] = investments[i] / sum * percConvert;
		}
		
		//Returning percentage array
		return perc;
	}
	
	/**
	 * This Method prints the investment amounts along with the percentage they make up as a whole.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static void printInvestPercs(double[] investments, double[] percents) {
		
		//Printing out investments and their percents as a whole
		for (int i = 0; i < investments.length; i++) {
			System.out.printf("$ %8.2f %10.3f%% \n", investments[i], percents[i]);
		}
	}
	
	/**
	 * This Method prints the investment Mean, Minimum, Maximum, and Total in a formatted fashion.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static void printMeanMinMaxTot(double mean, double min, double max, double tot) {
		
		//Printing out the Mean, Minimum, Maximum, and Total given.
		System.out.printf("Mean:     $ %8.2f \n", mean);
		System.out.printf("Minimum:  $ %8.2f \n", min);
		System.out.printf("Maximum:  $ %8.2f \n", max);
		System.out.printf("Total:    $ %8.2f \n", tot);
	}
	
	/**
	 * This Method counts and prints the total amount of Investments.
	 * 
	 * CSC 1350 Programming Project 9
	 * Section 1
	 * @author Cade M Forbes
	 * @since 4/17/2020
	 * 
	 */
	public static void printNumInvestments(double[] investments) {
		
		//Printing out the total amount of investments
		System.out.println("Total number of Investments: " + investments.length);
	}
	
	public static void main(String[] args) {
		
		double[] investments = arrayRequest();
		
		investments = investmentList(investments);
		
		double min = minimum(investments);  
		
		double max = maximum(investments);
		
		double sum = sum(investments);
		
		double avg = mean(investments, sum);
		
		double[] percs = percents(investments, sum);
		
		printInvestPercs(investments, percs);
		
		
		System.out.println();
		System.out.println();
		
		printMeanMinMaxTot(avg, min, max, sum);
		
		System.out.println();
		System.out.println();
		
		printNumInvestments(investments);
		

	}

}
