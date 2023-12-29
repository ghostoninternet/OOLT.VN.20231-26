package application.algorithms;

public class BubbleSort extends SortingAlgorithm {
	 public BubbleSort(int[] array) {
	      super(array);
	 }
	 public BubbleSort(int length) {
	      super(length);
	 }
	 
	 public void swap (int [] array, int i, int j){
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	 }
	 
	 public void compareElement(int [] array, int i, int j){
	      if(array[i] > array[j]){
	           swap(array,i,j);
	      }
	 }
	 @Override
	 public void Sort(){
	      for( int i = 0; i < array.length; i++){
	           for(int j = 0; j < array.length - i - 1 ; j++){
	               compareElement(array, j, j + 1);
	           }
	       }
	  }
}
