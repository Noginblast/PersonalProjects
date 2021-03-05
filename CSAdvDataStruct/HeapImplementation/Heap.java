import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class MinHeap{
	private int array[];
	private int arraySize;
	private int heapSize = 0;
	
	//Constructor
	public MinHeap(int arraySize) {
		this.arraySize = arraySize;
		this.array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			this.array[i] = Integer.MAX_VALUE;
		}
	}
	
	
	//Public Method for inserting key into heap and sorting
	public void insert(int key) {
		if(heapSize < arraySize) {
			array[heapSize] = key;
			this.heapSize++;
			fixHeap();
		}
		else {
			System.out.println("ERROR: HEAP FULL");
		}
	}
	
	
	//Public Method for find an element at an index and lowering its value
	public void decreaseKey(int index, int element) {
		if (array[index] != Integer.MAX_VALUE) {
			array[index] = element;
			fixHeap();
		}
		else {
			System.out.println("ERROR: NO ELEMENT IN NODE " + (index));
		}
	}
	
	
	//Public Method to extract and return the smallest value in the heap
	public int extractMin() {
		if (heapSize > 0) {
			int minElement = this.array[0];
			this.array[0] = this.array[heapSize-1];
			this.array[heapSize -1] = Integer.MAX_VALUE;
			this.heapSize--;
			fixHeap();
			
			return minElement;
		}
		else {
			System.out.println("ERROR: NO ELEMENTS IN HEAP");
			return 0;
		}
		
	}
	
	
	//Private Method to re-organize heap
	private void fixHeap() {
		
		int n = (int)(this.heapSize / 3.0);
		
		while (n != -1) {
			if(this.array[(n*3)+1] != Integer.MAX_VALUE) {
				if(this.array[n] > this.array[(n*3)+1]) {
					swap(n,(n*3)+1);
				}
			}
			if(this.array[(n*3)+2] != Integer.MAX_VALUE) {
				if(this.array[n] > this.array[(n*3)+2]) {
					swap(n,(n*3)+2);
				}
			}
			if(this.array[(n*3)+3] != Integer.MAX_VALUE) {
				if(this.array[n] > this.array[(n*3)+3]) {
					swap(n,(n*3)+3);
				}
			}
			n--;
		}
	}
	
	
	//Private Method to swap node values within heap
	private void swap(int i, int j) {
		int tmp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = tmp;
	}
	
}


public class Heap {

	public static void main(String[] args) throws FileNotFoundException{
		
		int heapSize;
		int instructNum = 0;
		
		//Creating file and scanner objects
		File input = new File("inputFile.txt");
		Scanner file = new Scanner(input);
		
		
		//Vetting File object for instruction length
		if(file.hasNextLine()) {
			instructNum = Integer.parseInt(file.nextLine());
		}
		
		heapSize = instructNum;
		
		MinHeap mh = new MinHeap(heapSize);
		
		
		//Reading and executing file commands
		while (instructNum >= 1 && file.hasNextLine()) {
			String[] line = file.nextLine().split(" ");
			
			if(line[0].equals("IN")) {
				mh.insert(Integer.parseInt(line[1]));
			}
			else if(line[0].equals("DK")) {
				mh.decreaseKey(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			}
			else if(line[0].equals("EM")) {
				int minElement = mh.extractMin();
				if(instructNum == 1) {
					System.out.println(minElement);
				}
			}
			instructNum--;
		}

	}

}
