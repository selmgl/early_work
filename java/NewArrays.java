/*
/* Java Programming : Arrays
*/

public class NewArrays {

    // elementary element of an array
    static class AnEntry {
	private String name;
	private int value;

	// basic constructor
	public AnEntry(String n, int v) {
	    name = n;
	    value = v;
	}

	//basic accessors
	public String getName() { return name;}
	public int getValue() { return value;}
    
    }

    // an array of AnEntry
    static class EntryArray {
	private AnEntry[] entryArray;
	private int entryCount;

	// constructors, empty, specific size, copy
	public EntryArray() {
	    entryArray = null;
	    entryCount = 0;
	}
	public EntryArray(int size) {
	    entryArray = new AnEntry[size];
	    entryCount = 0;
	}
	public EntryArray(AnEntry[] entries) {
	    entryArray = null;
	    entryCount = 0;
	    for (int i=0; i < entries.length; i++) {
		entryArray[i] = entries[i];
		entryCount++;
	    }
	}
	public void addEntry(AnEntry e) {
	    // add an entry to the array
	}
    }

    // main method
    public static void main(String[] args) {
	System.out.println("Java Arrays");
	AnEntry entry1 = new AnEntry("one", 1);
	AnEntry entry2 = new AnEntry("two", 2);
	AnEntry entry3 = new AnEntry("two", 3);
	EntryArray aofent1 = new EntryArray();
	EntryArray aofent2 = new EntryArray(2);
	//EntryArray aofent3 = new EntryArray([entry1, entry2, entry3]);
	
    }
}
