package application.algorithms;

public class MergeSort extends SortingAlgorithm{
	
	public MergeSort(int[] array, int arrayLength) {
	        super(array, arrayLength);
	}
	public MergeSort(int length) {
        super(length);
}
	public void merge (int [] array, int left, int right, int middle){
        // Find sizes of two subarrays to be merged
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;
        
        // Initial two subarrray with size
        int [] leftArray = new int[leftArraySize];
        int [] rightArray = new int[rightArraySize];
        // Copy data to left array
        for(int i = 0; i < leftArraySize ; i++){
            leftArray[i] = array[left + i];
        }
        // Copy data to right array
        for(int j = 0; j < rightArraySize; j++){
            rightArray[j] = array[middle + j + 1 ];
        }
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
            subIndex ++;
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
    }
	
    public void mergeSort(int [] array, int left, int right){
        if(left < right){
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle );
            mergeSort(array, middle + 1, right);

            merge(array, left, right, middle);
        }
    }
    @Override 
	public void Sort() {
    	for(int i = 0; i < 5; i++) {
    		System.out.println(array[i]);
    	}
		mergeSort(array, 0, arrayLength - 1);
	}
}
