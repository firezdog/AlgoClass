package week2;

//Actually this is a linked STACK of strings.

public class LinkedListStrings {
	private Node first = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(String item) {
		//It's not necessary to have an 'if' check, because if there was no first, the first will just point to oldFirst == null.
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public String pop() {
		Node oldfirst = first;
		first = first.next;
		return oldfirst.item;
	}
	
	public static void main(String[] args) {
		LinkedListStrings ll = new LinkedListStrings();
		
		for (String arg : args) {
			if (arg.equals("-")) System.out.println(ll.pop());
			else ll.push(arg);
		}
	}

}
