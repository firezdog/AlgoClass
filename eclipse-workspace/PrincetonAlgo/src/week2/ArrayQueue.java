package week2;

public class ArrayQueue {
	private String[] q = new String[1];
	private int head = 0;
	private int tail;
	
	public void enqueue(String item) {
		if (isEmpty()) q[head] = item;
		else if (q[tail] != null) {
			resize(2*q.length);
		}
		else { 
			q[tail] = item;
			tail = (tail + 1) % q.length;
		}
	}
	
	public void resize(int capacity) {
		String[] newQ = new String[capacity];
		int start = 0;
		for (int i = head; i != tail; i = (i + 1) % q.length) {
			newQ[start] = q[i];
			start++;
		}
		tail = q.length;
		head = 0;
		q = newQ;
	}
	
	public String dequeue() {
		if (isEmpty()) return null;
		else {
			String item = q[head];
			q[head] = null;
			head = (head + 1) % q.length;
			return item;
		}
	}
	
	public int size() {
		if (q[head] == null) return 0;
		else if (head < tail) return tail - head;
		else return -(tail - head) + q.length;
	}
	
	public boolean isEmpty() {
		return q[head] == null;
	}
}
