/**
 * This program is designed to calculate the team score for a gymnastics event.
 * 
 * CSC 1350 Programming project No 6
 * Section 1
 * 
 * @author cforb19
 * @since 03/5/2020
 *
 */

import java.util.Scanner;
public class Prog06_Gymnastics {

	public static void main(String[] args) {
		String event; 			//Name of the Event 
		double score = 0; 		//Declaring and initializing variable for the scores 
		double scoreTotal = 0;	//Declaring and initializing variable for score totals
		int i = 1; 				//Declaring and initializing iteration variable
		
		Scanner in = new Scanner(System.in); //Starting scanner
		
		
		//Gathering user input for event name
		System.out.println("Enter gymnastics event:");
		event = in.nextLine();
		System.out.println();
		
		
		
		//Retrieving user scores
		System.out.println("Please provide the top 5 scores for the event.");
		for (; i <= 5; i++) {
			
			//Validating User input
			while (true) {
				System.out.println("Enter score:");
				
				if (in.hasNextDouble()) {
					score = in.nextDouble();
					in.nextLine();
					break;
				}
				else {
					System.out.print("Value provided is not a number: " + in.next());
					in.nextLine();
					System.out.println();
				}
				
			}
			
			//Adding total
			scoreTotal= scoreTotal + score;
		}
		
		//Printing result
		System.out.println();
		System.out.printf("%s score: %.3f",event,scoreTotal);
	}

}
