/*
 * Java Programming : fun with Arrays
 *
 */

import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;

public class ArrayMethods {

    private static Boolean debug = true; // set to false if not debugging
    
    /** sort method for an Array of String
     * sort in Array, doesn't return one
     */
    public static String[] mergesortAoS (String[] strings) {

	String temp; // temporary storage string
	String[] stringsL, stringsR, stringsOut; // arrays used for the recursion
	int mid; // index of middle to split array
	int i, j, n; // index for loops

	if (debug) {
	    System.out.print("treating string array:");
	    printAoS(strings);
	}
	
	if (strings.length < 1) {
	    // this case should not happen
	    throw new IndexOutOfBoundsException("Array of length 0 in mergeSort");
	}
	// this case is entered if the string is odd length
	else if (strings.length == 1) {
	    return strings;
	}
	// end case for even arrays
	else if (strings.length == 2) {
	    if (strings[0].compareTo(strings[1]) <= 0) {
		// strings is ordered
		return strings;
	    }
	    else {
		// we need to switch strings
		temp = strings[0];
		strings[0] = strings[1];
		strings[1] = temp;
		return strings;
	    }	    
	}
	else {
	    // basic recursive case
	    // split array at mid and sort both sides
	    mid = strings.length/2;
	    stringsL = mergesortAoS(Arrays.copyOfRange(strings, 0, mid));
	    stringsR = mergesortAoS(Arrays.copyOfRange(strings, mid, strings.length));

	    if (debug) {
		System.out.print("merging array of size "+stringsL.length+" :");
		printAoS(stringsL);
		System.out.print("with array of size "+stringsR.length+" :");
		printAoS(stringsR);
	    }
	    
	    // then merge them in order
	    // iterate on left string
	    i = 0;
	    j = 0;
	    n = 0;
	    stringsOut = strings;
	    while (i < stringsL.length && j < stringsR.length) {
		if (debug) System.out.println("merge indexes: i="+i+", j="+j+", n="+n);
		// L < R we insert L and increase L index
		if (stringsL[i].compareTo(stringsR[j]) <= 0) {
		    stringsOut[n] = stringsL[i];
		    i++;
		    n++;
		}
		else {
		    stringsOut[n] = stringsR[j];
		    j++;
		    n++;
		}
	    }
	    // we have finished one side, the remaining one must be last biggest
	    // did we finish L ?
	    if (i == stringsL.length) {
		stringsOut[n] = stringsR[j];
	    }
	    // if not then we finished R
	    else {
		stringsOut[n] = stringsL[i];
	    }	     
	}
	    
	return stringsOut;
    }

    /** display an Array of Strings on default output 
     */
    public static void printAoS (String[] strings) {

	for (String s : strings) {
	    System.out.print(s+", ");
	}
	System.out.println("");
    }

    /** binary search, requires a sorted input array
     */

    /** recursive submethod for binary search
     */
    public static int bsR (String[] strings, String s, int start, int stop) {

	if (debug) System.out.println("rec-searching "+s+"between pos "+start+" and "+stop); 
	
	// pick middle element, compare it to s, chose which side to search
	int mid = (stop-start)/2;
	// we found s
	if (strings[mid] == s) {
	    return mid;
	}
	if (strings[mid].compareTo(s) <= 0) {
	    // search right
	    return bsR(strings, s, mid+1, stop);
	}
	else {
	    // search left
	    return bsR(strings, s, start, mid);
	}
    }
    
    /** main search, uses recursive submethod
     */
    public static int binarySearchAoS (String[] strings, String s) {
	// treat special cases
	if (strings.length == 0 || s == "") {
	    throw new IndexOutOfBoundsException("Wrong input in binary search");
	}
	// 1 element array case, if not s then s is not in strings
	else if (strings.length == 1) {
	    if (strings[0] == s) return 0;
	    else return -1;
	}
	else {
	    return bsR(strings, s, 0, strings.length-1);
	}
    }
    
    /** main testing class
     */
    public static void main ( String[] args) {
	System.out.println("ArrayMethods tests");
	// basic tests for class methods
	String[] aos1 = {"5","3","2","4","1"};
	String[] aos2 = {"1"};
	String[] aos3 = {"1","2"};
	String[] aos4 = {"2","1"};
	String[] aos5 = {"2","3","1"};
	// tests for mergesort
	printAoS(aos2); // size 1 array
	printAoS(mergesortAoS(aos2));
	printAoS(aos3); // already ordered size 2 array
	printAoS(mergesortAoS(aos3));
	printAoS(aos4); // not ordered size 2 array
	printAoS(mergesortAoS(aos4));
 	printAoS(aos5); // not ordered size 3 array
	printAoS(mergesortAoS(aos5));
	printAoS(aos1); // not ordered size 1 array
	printAoS(mergesortAoS(aos1));
	// tests for binary search
	System.out.print("searching string 1 in array:");
	printAoS(aos2);
	System.out.println("found at position "+binarySearchAoS(aos2,"1"));
	System.out.print("searching string 1 in array:");
	printAoS(aos3);
	System.out.println("found at position "+binarySearchAoS(aos3,"1"));
	System.out.print("searching string 1 in array:");
	printAoS(aos5);
	System.out.println("found at position "+binarySearchAoS(aos5,"1"));
    }
}
