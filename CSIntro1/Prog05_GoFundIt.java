/**
 * Help the user to make plans to fund a financial goal
 * 
 * CSC 1350 Programming project No 5
 * Section 1
 * 
 * @author cforb19
 * @since 02/27/2020
 *
 */

import java.util.Scanner;

public class Prog05_GoFundIt {

	public static void main(String[] args) {
		
		//Declaring variables
		String finGoal;				//Financial Goal
		double cost = 0;			//Cost of Goal
		boolean costInput = false;	//Boolean for validation loop
		
		
		double money = 0;		//Money raised for goal
		String moneyList;		//List from each source
		double totalMoney;		//Total from combined sources
		double dif;				//Difference between cost and totalMoney
	
		String sources_List;			//Sources of money raised
		String activity;		
		
		
		
		
		
		
		
		//Retrieving user input
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("What financial goal are you working toward?");
		finGoal = in.next();
		
		
		
		while (costInput == false) {
			System.out.println("How much money do you need to raise?");
			
		if (in.hasNextDouble()) {
			cost = in.nextDouble();
			in.nextLine();
			if (cost <= 0) {
				System.out.println("Error: Cost must be a positive number.");
			}
			else {
				break;
			}
		}
		else {
			System.out.print("Error: Not a number.");
			in.nextLine();
			
		}
		System.out.println();
		
		}
		System.out.println(); 
		
	
		
		
		
		
		
		
		//Retrieving user's plan
		System.out.println("What source can you use to raise some money?");
		sources_List = in.nextLine();
		

		
		while (costInput == false) {
			System.out.println("How much money do you expect that it will raise?");
			
		if (in.hasNextDouble()) {			//input validation
			money = in.nextDouble();
			in.nextLine();
			
			if (money < 0) {
				System.out.println("Error: Money must be 0 or positive.");
			}
			else {
				break;
			}
		}
		else {
			System.out.print("Error: Not a number.");
			in.nextLine();
		}
		System.out.println();
		}
		
		moneyList = "$" + money + "\n";
		
		
		activity = "Activity: \n";
		totalMoney = money;					//Initializing totalMoney
		while (totalMoney < cost) {
			
			dif = cost - totalMoney;
			System.out.println("You still need to raise $" + dif + " to reach your financial goal.");
			System.out.println("What source can you use to raise some money?");
			sources_List = sources_List + in.nextLine() + "\n";
			System.out.println("How much money do you expect that it will raise?");
			money = in.nextDouble();
			
			activity = activity + "Activity: \n";
			
			while (costInput = false) {
			if (in.hasNextDouble()) {			//input validation
				money = in.nextDouble();
				in.nextLine();
				
				if (money < 0) {
					System.out.println("Error: Money must be 0 or positive.");
				}
				else {
					
				}
			}
			else {
				System.out.print("Error: Not a number.");
				in.nextLine();
			}
			System.out.println();
			}
			
			totalMoney = totalMoney + money;
			moneyList = moneyList + "$" + money + "\n";
		}
		
		System.out.printf("Goal: %s; $%.2f \n", finGoal, cost);
		System.out.println(activity + sources_List + moneyList);
		
		
		
	}

}
