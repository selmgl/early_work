/*
 * Java Programming : Base conversion and comparison
 */

/** BaseConversion takes strings as inputs and a given base (2, 8, 10, 12 or 16) 
 *  
 */
public class BaseConversion {

    private Boolean debug = false;
    
    /** CharValue gives value of a character
     *  base is not considered, should be <= 16 though
     */
    public int CharValue (char c) {
	if (c >= '0' && c <= '9') {
	    return (c-'0');
	} else if (c >= 'A' && c <= 'F') {
	    return (c-'A'+10);
	} else if (c >= 'a' && c <= 'f') { // if not capitals
	    return (c-'a'+10);
	} else
	    return -1;
    }

    /** Base10Value provides a base 10 value of the string
     */
    public int Base10Value (String num, int base) {
	int digit = 0;
	int total = 0;
	int expo = 0;
	for (int pos = num.length()-1; pos >= 0; pos--) {
	    digit = CharValue(num.charAt(pos));
	    if (debug) System.out.print("pos:"+pos+" ,digt:"+digit+";");
	    if (digit > base) return -1;
	    total += digit * Math.pow(base, expo);
	    expo++;
	}
	return total;
    }

    /** CompareNumbers returns true if numbers are equal
     * numbers are provided as strings, with their base (int) 
     * return 0 if equal and 1 if different
     */
    public int CompareNumbers (String num1, int base1, String num2, int base2) {
	int value1 = Base10Value(num1, base1);
	int value2 = Base10Value(num2, base2);
	if ((value1 == -1) || (value2 == -1))
	    return -1;
	else if (value1 == value2)
	    return 0;
	else
	    return 1;
    }
    
    /** main method, used to test public classes
     */
    public static void main (String[] args) {
	System.out.println("Base Conversion in Java");
	BaseConversion prog = new BaseConversion();
	// preliminary tests
	System.out.println("CharValue Testing");
	System.out.println("Test1, expect 0, gets "+prog.CharValue('0'));
	System.out.println("Test2, expect 1, gets "+prog.CharValue('1'));
	System.out.println("Test3, expect 10, gets "+prog.CharValue('A'));
	System.out.println("Test4, expect 12, gets "+prog.CharValue('C'));
	System.out.println("Test5, expect 15, gets "+prog.CharValue('F'));
	System.out.println("Test6, expect -1, gets "+prog.CharValue('H'));
	System.out.println("Base10Value Testing");
	System.out.println("Test10, expect 0, gets "+prog.Base10Value("0", 10));
	System.out.println("Test11, expect 1, gets "+prog.Base10Value("1", 10));
	System.out.println("Test12, expect 0, gets "+prog.Base10Value("0", 2));
	System.out.println("Test13, expect 0, gets "+prog.Base10Value("0", 16));
	System.out.println("Test14, expect 14, gets "+prog.Base10Value("14", 10));
	System.out.println("Test15, expect 846, gets "+prog.Base10Value("846", 10));
	System.out.println("Test16, expect -1, gets "+prog.Base10Value("54F", 10));
	System.out.println("Test17, expect 9, gets "+prog.Base10Value("1001", 2));
	System.out.println("CompareNumbers Testing");
	System.out.println("Test20, expect 0, gets "+prog.CompareNumbers("0",2,"0",2));
	System.out.println("Test21, expect 0, gets "+prog.CompareNumbers("10",2,"10",2));
	System.out.println("Test22, expect 1, gets "+prog.CompareNumbers("0",2,"1",2));
	System.out.println("Test23, expect -1, gets "+prog.CompareNumbers("0",2,"5",2));
	System.out.println("Test24, expect 0, gets "+prog.CompareNumbers("11",2,"3",10));
	System.out.println("Test25, expect 0, gets "+prog.CompareNumbers("25",10,"1A",16));
	System.out.println("Test26, expect 1, gets "+prog.CompareNumbers("25",10,"1B",16));
    }

}

