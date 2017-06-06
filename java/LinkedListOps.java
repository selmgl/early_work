/*
 * Java Programming: Some operations on linked lists
 */

import java.util.Hashtable;
import java.lang.IndexOutOfBoundsException;

public class LinkedListOps<D> {

    private static class Node<D> {
	private D data;
	private Node<D> next;

	public Node(D d, Node<D> n) {
	    data = d;
	    next = n;
	}
	// usage: n.getData(), returns n data
	public D getData() {return data;}
	// usage: n.getNext(), returns n next node
	public Node<D> getNext() {return next;}
	// usage: n.setNext(node), sets n next node to <node>
	public void setNext(Node<D> n) {next = n;}
    }

    private Node<D> head = null; // declares default head of a list
    public int size = 0; // dafault size of the list

    public LinkedListOps() {} // default empty constructor for a list

    /** returns the head of a list
     * used for methods that takes the head node as input instead of the list itself
     */
    public Node<D> getHead() {
	return head;
    }
    
    /** reset the head of a list
     * used to remove elems, when the head can be removed
     */
    public void setHead(Node<D> n) {
	this.head = n;
    }
    
    /** add element to the head of the list
     */
    public void add(D d) {
	Node<D> newNode = new Node(d, head);
	head = newNode;
    }

    /** remove first occurrence of elem
     * does nothing if d doesn't exist
     */
    public Node<D> remove(Node<D> head, D d) {
	Node<D> current = head;
	// specific first cases
	if (current == null) return null;
	if (current.getData() == d) return current.getNext();
	// generic case
	while (current != null && current.getNext() != null) {
	    // if next node data is d then remove next node
	    if (current.getNext().getData() == d) {
		current.setNext(current.getNext().getNext());
	    }
	    current = current.getNext();
	}
	return head;
    }
    
    /** delete duplicates in a linked list
     */
    public void deleteDups(Node<D> n) {
	Hashtable<D,Boolean> dupsTable = new Hashtable<D,Boolean>();
	Node previous = null;
	while (n != null) {
	    if (dupsTable.containsKey(n.getData())) {
		previous.setNext(n.getNext());
	    } else {
		dupsTable.put(n.getData(), true);
		previous = n;
	    }
	}
	n = n.getNext();
    }

    /** returns Kth element of a list
     */
    public D kthElem(int k) {
	Node<D> n = head;
	// pass through the k-1th first elements (if possible)
	for (int i=1; i<k; i++) {
	    if (n.getNext() == null)
		throw new IndexOutOfBoundsException(k+" is out of bound of list!");
	    n = n.getNext();
	}
	return n.getData();
    }

    /** prints a list (if data can be converted to string
     */
    public void print() {
	Node<D> current = head;
	while (current != null) {
	    System.out.print(current.getData()+",");
	    current = current.getNext();
	}
	System.out.println("");
    }
    
    /** main to test methods
     */
    public static void main (String[] args) {
	System.out.println("Linked list manipulations in Java");
	// preliminary tests
	LinkedListOps newList = new LinkedListOps();
	newList.add(5);
	newList.add(4);
	newList.add(3);
	newList.add(2);
	newList.add(1);
	newList.print();
	System.out.println("Test1, expect 1, gets "+newList.kthElem(1));
	System.out.println("Test1, expect 4, gets "+newList.kthElem(4));
	newList.setHead(newList.remove(newList.getHead(),2));
	newList.print();
    }

}