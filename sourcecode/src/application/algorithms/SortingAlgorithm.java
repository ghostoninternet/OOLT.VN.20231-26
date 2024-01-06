package application.algorithms;

import java.util.Random;

public abstract class SortingAlgorithm {
	protected int[] array;
	protected int arrayLength;
	protected StringBuffer[] sortingProcessArray = new StringBuffer[10000];
	protected int step = 1;
	
	public SortingAlgorithm(int[] array, int arrayLength) {
		this.array = array;
		this.arrayLength = arrayLength;
	}
	
	// Contructor generate random array
	public SortingAlgorithm(int length) {
		this.array = generateRandomArray(length);
		this.arrayLength = length;
	}
	
	// Generate ramdom array with length
	private int[] generateRandomArray(int length) {
		 Random random = new Random();
	     int[] randomArray =  random.ints(length, 0, 1000).toArray();
	     return randomArray;
    }
	
	public abstract StringBuffer[] Sort();
	// Getter SortingAlgorithm
	public int[] getArray() {
		return array;
	}
}
