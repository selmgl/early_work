/*
 * Java Programming : Anagram problem solved through sorting
 */

/** AnagramSort
 * compare two strings by sorting them and then checking for equality
 */
public class AnagramSort {

    /** sorting method for a string
     * uses CharArray
     */
    public String sort(String s) {
	char[] chars = s.toCharArray();
	java.util.Arrays.sort(chars);
	return new String(chars);
    }

    /** anagram
     */
    public Boolean anagram(String s1, String s2) {
	if (s1.length() != s2.length()) return false;
	return sort(s1).equals(sort(s2));
    }

    /** main method with test suite
     */
    public static void main (String[] args) {
	System.out.println("Anagram Test in Java");
	AnagramSort prog = new AnagramSort();
	// preliminary tests
	System.out.println("String sort Testing");
	System.out.println("Test1, expect \"abcd\", gets "+prog.sort("acbd"));
	System.out.println("Test2, expect \"\", gets "+prog.sort(""));
	System.out.println("Anagram Testing");
	System.out.println("Test10, expect true, gets "+prog.anagram("",""));
	System.out.println("Test11, expect true, gets "+prog.anagram("a","a"));
	System.out.println("Test12, expect false, gets "+prog.anagram("","a"));
	System.out.println("Test13, expect false, gets "+prog.anagram("a",""));
	System.out.println("Test14, expect true, gets "+prog.anagram("abcd","adcb"));
	System.out.println("Test15, expect false, gets "+prog.anagram("abcd","abcde"));
	System.out.println("Test16, expect false, gets "+prog.anagram("abcd","abbc"));

    }
}
