package week2;

public class QueueOfStrings {
	
	private Node first = null;
	
	public class Node {
		String item;
		Node next;
	}
	
	//Add item at the end.
	public void enqueue(String item) {
		if (first == null) {
			first = new Node();
			first.item = item;
		} else {
			Node walker = first;
			while (walker.next != null) {
				walker = walker.next;
			}
			walker.next = new Node();
			walker.next.item = item;
		}
	}
	
	//Remove from the beginning.
	public String dequeue() {
		if (first == null) return null;
		Node oldFirst = first;
		first = first.next;
		return oldFirst.item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		if (first == null) return 0;
		int size = 1;
		Node walker = first;
		while (walker.next != null) {
			walker = walker.next;
			size++;
		}
		return size;
	}
	
	public static void main(String[] args) {
		//isEmpty should return true when the list is empty.
		QueueOfStrings q = new QueueOfStrings();
		System.out.println(q.isEmpty());
		//isEmpty should return false when the list is not empty.
		q.enqueue("Hello");
		System.out.println(q.isEmpty());
		//size of list should increase as elements are queued.
		System.out.println(q.size());
		q.enqueue("world");
		System.out.println(q.size());
		//dequeue should return elements in the order they were queued and decrease size of queue
		System.out.println(q.dequeue());
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.size());
	}

}
