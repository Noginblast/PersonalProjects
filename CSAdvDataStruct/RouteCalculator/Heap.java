

public class Heap{
	private HashTable.HTObject array[];
	private int arraySize;
	private int heapSize = 0;
	HashTable htPos = new HashTable();
	
	//Constructor
	public Heap(int arraySize) {
		this.arraySize = arraySize;
		this.array = new HashTable.HTObject[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			this.array[i] = HashTable.inf();
		}
	}
	
	
	//Public Method for inserting key into heap and sorting
	public void insert(HashTable.HTObject key) {
		if(heapSize < arraySize) {
			array[heapSize] = key;
			htPos.putPos(array[heapSize].src, heapSize);
			this.heapSize++;
			fixHeap();
		}
		else {
			System.out.println("ERROR: HEAP FULL");
		}
	}
	
	
	//Public Method for find an element at an index and lowering its value
	public void decreaseKey(int index, HashTable.HTObject element) {
		if (array[index] != HashTable.inf()) {
			array[index] = element;
			fixHeap();
		}
		else {
			System.out.println("ERROR: NO ELEMENT IN NODE " + (index));
		}
	}
	
	
	//Public Method to extract and return the smallest value in the heap
	public HashTable.HTObject extractMin() {
		if (heapSize > 0) {
			HashTable.HTObject minElement = this.array[0];
			this.array[0] = this.array[heapSize-1];
			this.array[heapSize -1] = HashTable.inf();
			this.heapSize--;
			fixHeap();
			
			return minElement;
		}
		else {
			System.out.println("ERROR: NO ELEMENTS IN HEAP");
			return null;
		}
		
	}
	
	public int getPos (String src) {
		return htPos.getPos(src);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Private Method to re-organize heap
	private void fixHeap() {
		
		int n = (int)(this.heapSize / 2.0);
		
		while (n != -1) {
			if(array[(n*2)+1].timeArr != HashTable.inf().timeArr) {
				if(this.array[n].timeArr > this.array[(n*2)+1].timeArr) {
					htPos.putPos(array[(n*2)+1].src, n);
					swap(n,(n*2)+1);
				}
			}
			if(this.array[(n*2)+2].timeArr != HashTable.inf().timeArr) {
				if(this.array[n].timeArr > this.array[(n*2)+2].timeArr) {
					htPos.putPos(array[(n*2)+2].src, n);
					swap(n,(n*2)+2);
				}
			}
			
			n--;
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Private Method to swap node values within heap
	private void swap(int i, int j) {
		HashTable.HTObject tmp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = tmp;
	}
	
}


