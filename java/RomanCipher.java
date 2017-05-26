/*
/* Java Programming : Roman Cipher
*/

/** Simple implementation of a roman cipher based on ascii letters */
public class RomanCipher {

    protected Boolean debug = true; 
    protected char[] encoder = new char[26];

    // default constructor
    public RomanCipher(Boolean debug) {
	this.debug = debug;
	System.out.println("New instance of cipher created");
    }
    
    // the basic cipher method
    // roman rotation cipher from character given
    public String cipherText(String s, char coder) {
	int rotation = coder - 'A';
	char[] producedMsg = s.toCharArray();
	
	// fill encoder
	for (int i=0; i<26; i++)
	    encoder[i] = (char) ('A'+(i+rotation)%26);
	if (debug) System.out.println("Encoder: "+new String(encoder));
	// encode given string
	for (int i=0; i < producedMsg.length; i++) {
	    if (Character.isUpperCase(producedMsg[i])) {
		// determine int equivalent of letter to code
		int j = producedMsg[i] - 'A'; // always >= 0
		if (debug) System.out.println("Letter "+ producedMsg[i] + " replaced by letter "+encoder[j]);
		producedMsg[i] = encoder[j]; // encode message
	    }
	}
	String output = new String(producedMsg);
	return output;
    }

    // reverse cipher (for validation)
    public String decipherText(String s, char coder) {
	char revcode = (char) (2*'A'-coder);
	if (debug) System.out.println("revcode is: "+revcode);
	if (debug) System.out.println("revcode B is: "+ (char) ('A'-1));
	return this.cipherText(s,revcode);
    }
    
    public static void main(String[] args) {
	RomanCipher cipher = new RomanCipher(false);
	
	String toCode = "THIS WILL BE ENCODED WITH ONE LETTER ROTATION";
	System.out.println("Original Text: "+ toCode);
	
	String coded = cipher.cipherText(toCode, 'B');
	System.out.println("Coded Text: "+ coded);
	
	String decoded = cipher.decipherText(coded, 'B');
	System.out.println("Decoded Text: "+ decoded);
    }
}
