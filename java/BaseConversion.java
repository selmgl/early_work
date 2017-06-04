/*
 * Java Programming : Base conversion and comparison
 */

/** BaseConversion takes strings as inputs and a given base (2, 8, 10, 12 or 16) 
 *  
 */
public class BaseConversion {

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
    public int Base10Value (String s, int base) {

	return 0;
    }
    
    /** main method, used to test public classes
     */
    public static void main (String[] args) {
	System.out.println("Base Conversion in Java");
	BaseConversion prog = new BaseConversion();
	// preliminary tests
	System.out.println("CharValue Testing");
	System.out.println("Test1, expect 0, gets "+prog.CharValue('0'));
	System.out.println("Test1, expect 1, gets "+prog.CharValue('1'));
	System.out.println("Test1, expect 10, gets "+prog.CharValue('A'));
	System.out.println("Test1, expect 12, gets "+prog.CharValue('C'));
	System.out.println("Test1, expect 15, gets "+prog.CharValue('F'));
	System.out.println("Test1, expect -1, gets "+prog.CharValue('H'));

    }

}

