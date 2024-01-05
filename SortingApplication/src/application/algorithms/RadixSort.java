package application.algorithms;

import java.util.Arrays;

public class RadixSort extends SortingAlgorithm {
	
	public RadixSort (int [] array, int arrayLength) {
		super(array, arrayLength);
	}
	public RadixSort (int length) {
		super(length);
	}
	// Find max of array
	public int getMax(int [] array){
        int max = array[0];
        for(int i = 1; i < arrayLength; i++){
            if(max < array[i]){
               max = array[i];
            }
        }
        return max;
    }

    public void countSort(int [] array, int n, int exp, StringBuffer sortingProcess){
        int [] output = new int[n];     // output array
        int [] count = new int[10];     // count array
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        String countOfOccurrences = "";
        for(int i = 0; i < n ; i++){
            count[(array[i] / exp) % 10]++;
        }
        for(int i = 1; i < 10 ; i++){
            count[i] += count[i - 1];
            countOfOccurrences += count[i] + " ";
        }
        sortingProcess.append("Count of occurrences: " + countOfOccurrences + "\n");
        // Build the output array
        String resultSortedArray = "";
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for(int i = 0; i < n; i++){
            array[i] = output[i];
            resultSortedArray += array[i] + " ";
        }
        sortingProcess.append("Result of sorting: " + resultSortedArray + "\n\n");
        sortingProcessArray[step] = sortingProcess;
        step++;
    }
    public void radixSort(int [] array){
        // Find the maximum number to know number of digits
        int max = this.getMax(array);
        for(int exp = 1; max / exp > 0; exp *= 10){
        	StringBuffer sortingProcess = new StringBuffer();
        	sortingProcess.append("Step " + step + ": Sort array ");
        	String arrayToSort = "";
        	for (int i = 0; i < arrayLength; i++) {
        		arrayToSort += array[i] + " ";
        	}
        	sortingProcess.append(arrayToSort + "\n");
            countSort(array, arrayLength, exp, sortingProcess);
        }
    }
    
    @Override
    public StringBuffer[] Sort() {
    	radixSort(array);
    	return sortingProcessArray;
    }
}
