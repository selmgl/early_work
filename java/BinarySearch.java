/*
/* Java Programming : Binary Search
*/

import java.util.Arrays;

public class BinarySearch {

    protected Boolean debug = false;
    
    /* constructor used to set debug value */
    public BinarySearch (Boolean debug) {
	this.debug = debug;
    }
    
    /* toText displays an int array on screen as a string
     */
    public String toText (int[] inArray) {
	String stringArray = "";
	for (int val : inArray) stringArray = stringArray+" "+val;
	return stringArray;
    }
    
    /* arraySearch returns index of searched int, or -1 if not found
    */
    public int arraySearch (int tofind, int[] inArray, int start, int end) {
	int index = -1; //init index to -1, will be the dedault when not found
	// exit if the array section considered is empty
	if (end >= start) {
	    // middle of the array section considered
	    int midIndex = start+(end-start)/2;
	    int midValue = inArray[midIndex];
	    if (debug) System.out.println(midValue);

	    // if equal, searched value is in the middle
	    if (midValue == tofind) index = midIndex;
	    // if mid is smaller then searched value is on the right
	    else if (midValue < tofind) {
		index = arraySearch(tofind, inArray, midIndex+1, end);
	    }
	    // if mid is bigger then searched value is on the left
	    else {
		index = arraySearch(tofind, inArray, start, midIndex-1);
	    }
	}
	return index;
    }


    public static void main (String[] args) {
	BinarySearch thisprog = new BinarySearch(true);
	int[] inputArray = {2, 4, 12, 54, 23, 8, 49};
	int[] sortedArray = inputArray.clone();
	Arrays.sort(sortedArray);
	System.out.println("unsorted array: "+thisprog.toText(inputArray));
	System.out.println("sorted array: "+thisprog.toText(sortedArray));
	int index;
	index = thisprog.arraySearch(12, sortedArray, 0, sortedArray.length);
	System.out.println("Searching 12 at position 3 - result is "+index);
	index = thisprog.arraySearch(2, sortedArray, 0, sortedArray.length);
	System.out.println("Searching 2 at position 0 - result is "+index);
	index = thisprog.arraySearch(54, sortedArray, 0, sortedArray.length);
	System.out.println("Searching 54 at position 6 - result is "+index);
	index = thisprog.arraySearch(8, sortedArray, 0, sortedArray.length);
	System.out.println("Searching 8 at position 2 - result is "+index);
    }
}
