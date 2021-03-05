/**
 * This program is designed to print out a Christmas tree using asterisks.
 * 
 * CSC 1350 Programming project No 7
 * Section 1
 * 
 * @author cforb19
 * @since 03/12/2020
 *
 */

import java.util.Scanner;
public class Prog07_XmasTree {

	public static void main(String[] args) {
		
		int h; 		//height of tree
		
		
		//import scanner
		Scanner in = new Scanner(System.in);
		
		
		//input validation
		while (true) {				
					System.out.println("Enter height of Christmas tree:");
					 
					if (in.hasNextInt()) {
						h = in.nextInt();
						in.nextLine();
						if (h <= 2) {
							System.out.println("Christmas tree height must be larger than 2");
							System.out.println();
						}
						else {
							break;
						}
					}
					else {
						in.nextLine();
						System.out.println("Christas tree height must be an integer");
						System.out.println();
					}
		}
		
		
		
		//Creating body of tree
		for (int i = 0; i < h; i++) {
			
			for (int j = 0; j < h - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (2 * i + 1);k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		
		//Creating base of tree
		for (int l = 0; l < ((2 * h + 1) - 3)/2; l++) {
			System.out.print(" ");
		}
		
		System.out.println("***");
		
	
	}

}
