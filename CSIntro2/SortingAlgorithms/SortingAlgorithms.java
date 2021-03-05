import java.util.Arrays;

public class SortingAlgorithms {
	
	
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j+1] < arr[j]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void bubbleSortSC(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j+1] < arr[j]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			
			if(!swapped) {
				break;
			}
		}	
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minInd = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minInd]) {
					minInd = j;
				}
			}
			
			swap(arr, i, minInd);
		}
	}
	
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        }
	}
	
	public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
 
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
		
	public static void quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
  
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    }
	
	public static void pigeonholeSort(int arr[], int n) { 
		int min = arr[0]; 
		int max = arr[0]; 
		int range, i, j, index;  

		for(int a=0; a<n; a++) { 
			if(arr[a] > max) 
				max = arr[a]; 
			if(arr[a] < min) 
				min = arr[a]; 
		} 

		range = max - min + 1; 
		int[] phole = new int[range]; 
		Arrays.fill(phole, 0); 

		for(i = 0; i<n; i++) 
			phole[arr[i] - min]++; 


		index = 0; 

		for(j = 0; j<range; j++) 
			while(phole[j]-->0) 
				arr[index++]=j+min; 

}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	private static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    }
}
