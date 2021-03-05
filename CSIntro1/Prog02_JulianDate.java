/**
 * <<This program is designed to calculate the Julian date for any given date and time combination>>
 * 
 * CSC 1350 Programming project No 2
 * Section 1
 * 
 * @author cforb19
 * @since 1/30/2020
 *
 */

import java.util.Scanner;

public class Prog02_JulianDate {

	public static void main(String[] args) {
		//Step 1: Creating Date/Time Variables
		int day;
		int month;
		int year;
		
		int hour;
		int minute;
		int second;
		
		
		//Utilizing Scanner for custom Julian Date calculator
		Scanner in = new Scanner(System.in);
		
		System.out.println("Let's calculate the Julian date!");
		
		System.out.println("Enter the month (1-12):");   //Prompt for user input
		month = in.nextInt();
		
		System.out.println("Enter the day (1-31):");
		day = in.nextInt();
		
		System.out.println("Enter the year:");
		year = in.nextInt();
		
		System.out.println("Enter the hour (0-23):");
		hour = in.nextInt();
		
		System.out.println("Enter the minute (0-59):");
		minute = in.nextInt();
		
		System.out.println("Enter the second (0-59):");
		second = in.nextInt();
		
		System.out.println();
		
		//functions for Julian calculations:
		int julianDayNumber = (1461 * (year + 4800 + (month - 14)/12))/4 + (367 * (month - 2 - 12 * ((month - 14)/12)))/12 - (3 * ((year + 4900 + (month - 14)/12)/100))/4 + day - 32075;
		int julianDate = julianDayNumber + (hour - 12)/24 + minute/1440 + second/86400;
		
		
		
		System.out.println("The Julian Date is " + julianDate);
		
		
		
		
		
		/*
		
	    int dayOfTheWeek = (julianDayNumber + 1)%7;
	  
	    //Step 3: Print Out Findings
	    
		System.out.print(month + "/" + day + "/" + year + " ");
		System.out.println(hour + ":" + minute + ":" + second);
		
		System.out.println("has a Julian date of " + julianDate);
		
		System.out.println("and falls on the day of the week indicated by the number " + dayOfTheWeek);
		System.out.println();
		
		System.out.println("0 - Sunday");
		System.out.println("1 - Monday");
		System.out.println("2 - Tuesday");
		System.out.println("3 - Wednesday");
		System.out.println("4 - Thursday");
		System.out.println("5 - Friday");
		System.out.println("6 - Saturday");
		System.out.println();
		
		*/
	
		
		
	}

}
