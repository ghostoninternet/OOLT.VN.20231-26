package application.algorithms;

import java.util.Random;

public abstract class SortingAlgorithm {
	protected int [] array;
	
	public SortingAlgorithm(int [] array) {
		this.array = array;
	}
	
	// Contructor generate random array
	public SortingAlgorithm(int length) {
		this.array = generateRandomArray(length);
	}
	
	// Generate ramdom array with length
	private int[] generateRandomArray(int length) {
		 Random random = new Random();
	     int[] randomArray =  random.ints(length, 0, 1000).toArray();
	     return randomArray;
    }
	
	public abstract void Sort();
	// Getter SortingAlgorithm
	public int[] getArray() {
		return array;
	}
}
