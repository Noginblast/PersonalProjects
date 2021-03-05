//Student Name: Cade Forbes
//LSU ID: cforb19
//Lab TA: Augustine Orgah

import java.util.Scanner;
import java.util.Random;

public class Project7 {
	
	
	
	public static void main(String[] args) {
		int arrSize;	//Declaring Array Size variable
		
		//Creating Scanner and Random Number objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		
		//Prompting for user input and creating original array
		System.out.println("Enter array size:");
		arrSize = in.nextInt();
		int[] arrayBub = new int[arrSize];
		
		//Filling array with random integers in the range [0,1000]
		for (int i = 0; i < arrSize; i++) {
			arrayBub[i] = rand.nextInt(1001);
		}
	
		
		
		//Creating new arrays
		int[] arrayBubSC = new int[arrayBub.length];
		int[] arraySel = new int[arrayBub.length];
		int[] arrayIns = new int[arrayBub.length];
		int[] arrayMerge = new int[arrayBub.length];
		int[] arrayQuick = new int[arrayBub.length];
		int[] arrayPgn = new int[arrayBub.length];
		
		//Copying original array to clones
		for (int i = 0; i < arrayBub.length; i++) {
			arrayBubSC[i] = arrayBub[i];
			arraySel[i] = arrayBub[i];
			arrayIns[i] = arrayBub[i];
			arrayMerge[i] = arrayBub[i];
			arrayQuick[i] = arrayBub[i];
			arrayPgn[i] = arrayBub[i];
		}
		
		
		//Executing and measuring time for each algorithm
		long start = System.currentTimeMillis();
		SortingAlgorithms.bubbleSort(arrayBub);
		long elapsedBub = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		SortingAlgorithms.bubbleSortSC(arrayBubSC);
		long elapsedBubSC = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		SortingAlgorithms.selectionSort(arraySel);
		long elapsedSel = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		SortingAlgorithms.insertionSort(arrayIns);
		long elapsedIns = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		SortingAlgorithms.mergeSort(arrayMerge, 0, arrayMerge.length-1);
		long elapsedMerge = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		SortingAlgorithms.quickSort(arrayQuick, 0, arrayQuick.length-1);
		long elapsedQuick = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		SortingAlgorithms.pigeonholeSort(arrayPgn, arrayQuick.length);
		long elapsedPgn = System.currentTimeMillis() - start;
		
		
		//Printing time results of each algorithm
		System.out.println("Bubble Sort: " + elapsedBub + "ms");
		System.out.println("Bubble Sort Short Circuit: " + elapsedBubSC + "ms");
		System.out.println("Selection Sort: " + elapsedSel + "ms");
		System.out.println("Insertion Sort: " + elapsedIns + "ms");
		System.out.println("Merge Sort: " + elapsedMerge + "ms");
		System.out.println("Quick Sort: " + elapsedQuick + "ms");
		System.out.println("PigeonHole Sort: " + elapsedPgn + "ms");
		
	}

}
