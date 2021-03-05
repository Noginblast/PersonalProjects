/**
 * This program is designed to calculate the amount of financial assistance for needy families.
 * 
 * CSC 1350 Programming project No 8
 * Section 1
 * 
 * @author cforb19
 * @since 04/3/2020
 *
 */


import java.util.Scanner;
public class Prog08_NGO {
	
	/**
	 * This Method prompts for user input, validates input, and calculates financial assistance.
	 * Developed: 4/1/20
	 * Modified: 4/1/20
	 * @author Cade Forbes
	 * @return Financial Assistance Amount
	 */
	public static void finAssist() {
		Scanner in = new Scanner(System.in);
		int houseIncome;			//Household income
		int childCount;				//Child count
		int assistAmount;			//Financial  assistance amount
		
		
		//Input validation for household income:
		while (true) {
			System.out.println("Enter household income:");
			
			if (in.hasNextInt()) {
				houseIncome = in.nextInt();
				in.nextLine();
				if (houseIncome < 0) {
					System.out.println("Value must not be less than 0.");
					System.out.println();
				}
				else {
					break;
					}
				}
			else {
				System.out.println("Value must be a number.");
				System.out.println();
				in.nextLine();
			}
		}
		
		
		
		//Input validation for number of children:
		while (true) {
			System.out.println("Enter number of children:");
			
			if (in.hasNextInt()) {
				childCount = in.nextInt();
				in.nextLine();
				if (childCount < 0) {
					System.out.println("Value must not be less than 0.");
					System.out.println();
				}
				else {
					break;
					}
				}
			else {
				System.out.println("Value must be a number.");
				System.out.println();
				in.nextLine();
			}
		}
		
		
		
		//Calculation formula for Financial Assistance:
		if (((houseIncome < 45000) && (houseIncome >= 35000)) && (childCount >= 3)) {
			assistAmount = childCount * 1500;
		}
		else if (((houseIncome < 35000) && (houseIncome >= 25000)) && (childCount >= 2)) {
			assistAmount = childCount * 2000;
		}
		else if (houseIncome < 25000) {
			assistAmount = childCount * 2500;
		}
		else {
			assistAmount = 0;
		}
		
		
		
		//Printing of results:
		System.out.println();
		System.out.println("Household Income:   $" + houseIncome);
		System.out.println("Number of Children: " + childCount);
		System.out.println();
		System.out.println();
		System.out.println("Assistance Amount:  $" + assistAmount);
	}
	
	public static void main(String[] args) {
		
		finAssist();

	}

}
