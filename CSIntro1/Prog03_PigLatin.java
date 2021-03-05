/**
 * This program is meant to translate English words into the psuedo language, pig latin.
 * 
 * CSC 1350 Programming Project No 3
 * Section 1
 * 
 * @author Cade M Forbes
 * @since 02/06/2020
 *
 *
 *
 *
 */


import java.util.Scanner;


public class Prog03_PigLatin {

	public static void main(String[] args) {
		
		//Declaring Variables for the user word and its beginning letter classification
		String engWord; 
		String pigWord;
		
		int wordBegin;
		
		
		
		//Setting prompts for User input
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter an English word for conversation into pig Latin:");
		engWord = in.next();
		
		System.out.println("Does the word begin with a consonant or a vowel? (1 for consonant/2 for vowel):");
		wordBegin = in.nextInt();
		
		
		
		
		//Finding Length of the English word after it has been declared
		int engWordLength = engWord.length();
		
		
		
		
		//Setting condition and translating into Pig Latin
		if (wordBegin == 2) {
			pigWord = engWord + "-aye";
		}
		else {
			pigWord = engWord.substring(1,engWordLength) + "-" + engWord.substring(0,1) + "aye";
		}
		
		
		
		
		//Printing translated word
		System.out.printf("The English word \"%s\" is \"%s\" in pig latin.", engWord, pigWord);
		

	}

}
