package application.algorithms;

public class MergeSort extends SortingAlgorithm{
	
	public MergeSort(int[] array, int arrayLength) {
	    super(array, arrayLength);
	}
	public MergeSort(int length) {
        super(length);
	}
	public void merge (int [] array, int left, int right, int middle){
		StringBuffer sortingStepProcess = new StringBuffer("");
		sortingStepProcess.append("Step " + step + ": Merge two array\n");
		
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;
        
        // Initial two subarrray with size
        int [] leftArray = new int[leftArraySize];
        int [] rightArray = new int[rightArraySize];
        String leftArrayString = "";
        String rightArrayString = "";
        // Copy data to left array
        for(int i = 0; i < leftArraySize ; i++){
            leftArray[i] = array[left + i];
            leftArrayString += leftArray[i] + " ";
        }
        // Copy data to right array
        for(int j = 0; j < rightArraySize; j++){
            rightArray[j] = array[middle + j + 1 ];
            rightArrayString += rightArray[j] + " ";
        }
        
        sortingStepProcess.append("Left array to merge: " + leftArrayString + "\n");
        sortingStepProcess.append("Right array to merge: " + rightArrayString + "\n");
        // Initial indices of left and right subarrays
        int leftIndex = 0;
        int rightIndex = 0;
        // Initial index of merge subArray
        int subIndex = left;
        // 
        while(leftIndex < leftArraySize && rightIndex < rightArraySize){
            if(leftArray[leftIndex] <= rightArray[rightIndex]){ 
                array[subIndex] = leftArray[leftIndex];
                leftIndex++;
            }else {
                array[subIndex] = rightArray[rightIndex];
                rightIndex++ ;
            }
            subIndex++;
        }
        // Copy remaining elements of leftArray if any
        while(leftIndex < leftArraySize) {
            array[subIndex] = leftArray[leftIndex];
            leftIndex++;
            subIndex++;
        }
        // Copy remaining elements of rightArray if any
        while(rightIndex < rightArraySize){
            array[subIndex] = rightArray[rightIndex];
            rightIndex++;
            subIndex++;
        }
        String mergedArray = "";
        for (int i = left; i <= right; i++) {
        	mergedArray += array[i] + " ";
        }
        sortingStepProcess.append("Result of merge: " + mergedArray + "\n\n");
        sortingProcessArray[step] = sortingStepProcess;
        step++;
    }
	
    public void mergeSort(int [] array, int left, int right){
        if(left < right){
            int middle = left + (right - left) / 2;
            String arrayToDivide = "";
            for (int i = left; i <= right; i++) {
            	arrayToDivide += array[i] + " ";
            }
            
            StringBuffer sortingStepProcess = new StringBuffer("");
            sortingStepProcess.append("Step " + step + ": Divide array " + "[" + arrayToDivide + "]" + " into two array\n");
            String leftArray = "";
            String rightArray = "";
            for (int i = left; i <= middle; i++) {
            	leftArray += array[i] + " ";
            }
            for (int i = middle+1; i <= right; i++) {
            	rightArray += array[i] + " ";
            }
            sortingStepProcess.append("Left array: " + leftArray + "\n");
            sortingStepProcess.append("Right array: " + rightArray + "\n\n");
            sortingProcessArray[step] = sortingStepProcess;
            step++;
            mergeSort(array, left, middle );
            mergeSort(array, middle + 1, right);

            merge(array, left, right, middle);
        }
    }
    @Override 
	public StringBuffer[] Sort() {
		mergeSort(array, 0, arrayLength - 1);
		return sortingProcessArray;
	}
}
