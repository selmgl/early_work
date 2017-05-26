/*
/* Java Programming : Array of randomly generated numbers
*/

import java.util.Arrays;
import java.util.Random;

/** Some uses of random numbers and arrays */
public class RandomArray {
    public static void main (String[] args) {
	int data[] = new int[10];
	// pseudo random generator
	Random randGen = new Random();
	// set seed to current time
	randGen.setSeed(System.currentTimeMillis());
	// fill data array with random numbers 1..100
	for (int i=0; i < data.length; i++)
	    data[i] = randGen.nextInt(100);
	// copy original array (not simple reference)
	int[] orig = Arrays.copyOf(data, data.length);
	// check orig = data
	System.out.println("Both arrays are the same before sorting: "+Arrays.equals(data, orig));
	// sort data
	Arrays.sort(data);
	// recheck equality
	System.out.println("Both arrays are the same after sorting: "+Arrays.equals(data, orig));
	System.out.println("orig array = "+ Arrays.toString(orig));
	System.out.println("data array = "+ Arrays.toString(data));
    }
}
