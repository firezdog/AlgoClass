package week2;

public class Node<Item> {
	Item item;
	Node<Item> next;
	
	public Node(Item value) {
		item = value;
		next = null;
	}
	
	public static void main(String[] args) {
		//Create a linked list
		Node<String> first = new Node<String>("to");
		Node<String> second = new Node<String>("be");
		Node<String> last = new Node<String>("or");
		first.next = second;
		second.next = last;
		
		//Insert new node at the beginning.
		Node<String> oldFirst = first;
		first = new Node<String>("not");
		first.next = oldFirst;
		
		//Remove node from the beginning
		first = first.next;
		
		//Insert at the end
		Node<String> oldLast = last;
		last = new Node<String>("not");
		oldLast.next = last;
		
		//Traversal
		for (Node<String> x = first; x != null; x = x.next) {
			System.out.println(x.item);
		}
	}
}
