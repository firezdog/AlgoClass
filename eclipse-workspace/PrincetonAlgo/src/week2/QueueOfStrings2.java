package week2;

public class QueueOfStrings2 {
	
	private Node first;
	private Node last;
	private int count;
	
	class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(String item) {
//		if (first == null) {
//			first = new Node();
//			first.item = item;
//			last = first;
//		} else {
//			Node oldLast= last;
//			last = new Node();
//			last.item = item;
//			oldLast.next = last;
//		}
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		count++;
	}
	
	public String dequeue() {
		if (isEmpty()) { 
			last = null;
			return null;
		}
		String oldItem = first.item;
		first = first.next;
		count--;
		return oldItem;
	}
	
	public int size() {
		return count;
	}
	
}
