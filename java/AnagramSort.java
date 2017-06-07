/*
 * Java Programming : Anagram problem solved through sorting
 */

import java.util.Hashtable;
import java.util.LinkedList;

/** AnagramSort
 * compare two strings by sorting them and then checking for equality
 */
public class AnagramSort {

    /** sorting method for a string
     * uses CharArray
     */
    public static String sort(String s) {
	char[] chars = s.toCharArray();
	java.util.Arrays.sort(chars);
	return new String(chars);
    }

    /** anagram
     */
    public static Boolean anagram(String s1, String s2) {
	if (s1.length() != s2.length()) return false;
	return sort(s1).equals(sort(s2));
    }

    /** groups strings by anagrams in a string array
     */
    public static String[] anaSort(String[] array) {
	Hashtable<String, LinkedList<String>> hashT =
	    new Hashtable<String, LinkedList<String>>();

	// add all strings into the array to the hashtable
	for (String s : array) {
	    String key = sort(s);
	    // if key is not already in table, then add new field into it
	    if (! hashT.containsKey(key)) {
		hashT.put(key, new LinkedList<String>());
	    }
	    // now add s to the field in the hashT
	    LinkedList<String> anaList = hashT.get(key);
	    anaList.push(s);
	}

	// now put the whole hashtable in order into the array
	int index = 0;
	for (String key : hashT.keySet()) {
	    LinkedList<String> anaList2 = hashT.get(key);
	    for (String t : anaList2) {
		array[index] = t;
		index++;
	    }
	}
	
	return array;
	
    }

    /** prints an array of strings
     */
    public static void printSArray(String[] array) {
	for (String s : array) {
	    System.out.print(s+"', ");
	}
	System.out.println("");
    }
    
    /** main method with test suite
     */
    public static void main (String[] args) {
	System.out.println("Anagram Test in Java");
	// preliminary tests
	System.out.println("String sort Testing");
	System.out.println("Test1, expect \"abcd\", gets "+sort("acbd"));
	System.out.println("Test2, expect \"\", gets "+sort(""));
	System.out.println("Anagram Testing");
	System.out.println("Test10, expect true, gets "+anagram("",""));
	System.out.println("Test11, expect true, gets "+anagram("a","a"));
	System.out.println("Test12, expect false, gets "+anagram("","a"));
	System.out.println("Test13, expect false, gets "+anagram("a",""));
	System.out.println("Test14, expect true, gets "+anagram("abcd","adcb"));
	System.out.println("Test15, expect false, gets "+anagram("abcd","abcde"));
	System.out.println("Test16, expect false, gets "+anagram("abcd","abbc"));
	//anaSort tests
	String[] sArray = {"abc","def","acb","eff","dfe","abb"};
	System.out.print("Original String Array: ");
	printSArray(sArray);
	anaSort(sArray);
	System.out.print("String Array Grouped by Anagrams: ");
	printSArray(sArray);	
    }
}
