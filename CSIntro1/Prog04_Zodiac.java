/**
 * This program is designed to calculate a person's Zodiac sign, based on their birthday.
 * 
 * CSC 1350 Programming project No 4
 * Section 1
 * 
 * @author cforb19
 * @since 02/13/2020
 *
 */

import java.util.Scanner;


public class Prog04_Zodiac {

	public static void main(String[] args) {
		
		//Declaring variables for user input
		String userMonth;
		int userDay;
		String userZodiac = "";
		
		
		
		//Establishing user input
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your birtday (e.g., February 13):");
		userMonth = in.next();
		userDay = in.nextInt();
		
		
		
		//Establishing nest for Zodiac calculation
		if (userMonth.equals("January")) {
			if (userDay < 20) {
				userZodiac = "Capricorn";
				}
			else {
				userZodiac = "Aquarius";
			}
		}
		else if (userMonth.equals("February")) {
			if (userDay < 19) {
				userZodiac = "Aquarius";
				}
			else {
				userZodiac = "Pisces"; 
			}
		}
		else if (userMonth.equals("March")) {
			if (userDay < 21) {
				userZodiac = "Pisces";
				}
			else {
				userZodiac = "Aries"; 
			}
		}
		else if (userMonth.equals("April")) {
			if (userDay < 20) {
				userZodiac = "Aries";
				}
			else {
				userZodiac = "Taurus"; 
			}
		}
		else if (userMonth.equals("May")) {
			if (userDay < 21) {
				userZodiac = "Taurus";
				}
			else {
				userZodiac = "Gemini"; 
			}
		}
		else if (userMonth.equals("June")) {
			if (userDay < 21) {
				userZodiac = "Gemini";
				}
			else {
				userZodiac = "Cancer"; 
			}
		}
		else if (userMonth.equals("July")) {
			if (userDay < 23) {
				userZodiac = "Cancer";
				}
			else {
				userZodiac = "Leo"; 
			}
		}
		else if (userMonth.equals("August")) {
			if (userDay < 23) {
				userZodiac = "Leo";
				}
			else {
				userZodiac = "Virgo"; 
			}
		}
		else if (userMonth.equals("September")) {
			if (userDay < 23) {
				userZodiac = "Virgo";
				}
			else {
				userZodiac = "Libra"; 
			}
		}
		else if (userMonth.equals("October")) {
			if (userDay < 23) {
				userZodiac = "Libra";
				}
			else {
				userZodiac = "Scorpio"; 
			}
		}
		else if (userMonth.equals("November")) {
			if (userDay < 22) {
				userZodiac = "Scorpio";
				}
			else {
				userZodiac = "Sagittarius"; 
			}
		}
		else if(userMonth.equals("December")) {
			if (userDay < 22) {
				userZodiac = "Aries";
				}
			else {
				userZodiac = "Taurus"; 
			}
		}
		else {
		}
		
		
		//Printing result for user
		System.out.println();
		System.out.println("Your Zodiac sign is " + userZodiac);
		
		
		
		
		
		
		
		
	}
}
