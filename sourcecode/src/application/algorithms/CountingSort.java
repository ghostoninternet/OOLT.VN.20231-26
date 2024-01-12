package application.algorithms;
import java.util.Arrays;
public class CountingSort extends SortingAlgorithm {
	public CountingSort(int [] array, int arrayLength) {
		super(array, arrayLength);
	}
	public CountingSort(int length) {
		super(length);
	}
	public void countingSort(int [] array, int size){
		String sortingProcess = "";
        int[] outputArray = new int[size + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
            max = array[i];
        }
        sortingProcess += "Largest element of array: " + max + "\n";
        
        int [] countArray = new int[max + 1];
        // Initialize count array with all zeros.
        Arrays.fill(countArray,0);
        // Store the count of each element
        String countOfEachElement = "";
        int last = -1;
        for (int i = 0; i < size; i++) {
            countArray[array[i]]++;
        }
        for (int i = 0; i < size; i++) {
        	if (last != array[i]) {
        		countOfEachElement += "Element " + array[i] + ": " + countArray[array[i]] + "\n";
        	}
        }
        sortingProcess += "Count of each element: \n" + countOfEachElement + "\n\n";
        
        // Store the cummulative count of each array
        String cummulativeCount = "";
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
            cummulativeCount += countArray[i] + " ";
        }
        sortingProcess += "Cummulative count of array: " + cummulativeCount + "\n\n";
        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        String cummulativeCountOfElement = "";
        for (int i = size - 1; i >= 0; i--) {
        	cummulativeCountOfElement += "Element " + array[i] + ": " + countArray[array[i]] + "\n";
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
        sortingProcess += "Cummulative count of each element in original array: \n" + cummulativeCountOfElement;
        // Copy the sorted elements into original array
        String result = "";
        for (int i = 0; i < size; i++) {
            array[i] = outputArray[i];
            result += array[i] + " ";
        }
        sortingProcess += "Result of sorting: " + result + "\n\n";
        sortingProcessArray[step] = sortingProcess;
        step++;
	}
	@Override
	public String[] Sort() {
		countingSort(array, arrayLength);
		return sortingProcessArray;
	}
}
