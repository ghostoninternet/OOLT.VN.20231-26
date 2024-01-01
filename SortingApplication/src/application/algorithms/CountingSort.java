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
        int[] outputArray = new int[size + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
            max = array[i];
        }
        int [] countArray = new int[max + 1];
        // Initialize count array with all zeros.
        Arrays.fill(countArray,0);
        // Store the count of each element
        for (int i = 0; i < size; i++) {
            countArray[array[i]]++;
        }
        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }
        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = outputArray[i];
        }
	}
	@Override
	public void Sort() {
		countingSort(array, arrayLength);
	}
}
