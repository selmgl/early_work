/*
/* Java Programming : Counting words in a Text File
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCount {

    protected static Boolean debug = false;
    
    public static void main (String[] args) {
	// create the frequence dictionnary
	Map<String, Integer> freqDic = new HashMap<>();
	// scan input file
	File textFile = new File(args[0]);
	if (debug) System.out.println("Scanning text document: "+args[0]);
	try {
	    Scanner textDoc = new Scanner(textFile).useDelimiter("[^a-zA-Z]+");

	
	    if (debug) System.out.println("Computing Frequencies");
	    while (textDoc.hasNext()) {
		// convert word to lower case to reduce number of dic entries
		String word = textDoc.next().toLowerCase();
		if (debug) System.out.print(word); // print word to screen, will print all text file before giving frequencies, easier for debug
		Integer count = freqDic.get(word);
		// treat first occurrence of word
		if (count == null) count = 0;
		// update word frequence into dictionnary
		freqDic.put(word, count+1);
	    }
	    if (debug) System.out.println(""); // EOL if we printed the words 
	    System.out.println("List of words with their occurrences");
	    // print each word and number of occurrence
	    for (Map.Entry<String, Integer> item: freqDic.entrySet())
		System.out.println(item.getKey()+" : "+item.getValue());
	    // direct print of the hash map
	    System.out.println("Same output with direct print");
	    System.out.print(freqDic);
	    System.out.println("");
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}	
    }
}
