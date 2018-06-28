package week2;

public class ArrayQueue {
	private String[] q = new String[1];
	private int queueSize;
	private int head = 0;
	
	public int getHead() {
		return head;
	}
	
	public int getTail() {
		return tail;
	}
	
	private int tail = head;
	
	public void enqueue(String item) {
		if (isEmpty()) { 
			q[head] = item;
		}
		else if (q[tail] != null) {
			resize(2*q.length);
		}
		q[tail] = item;
		tail = (tail + 1) % q.length;
		queueSize++;
	}
	
	public void resize(int capacity) {
		String[] newQ = new String[capacity];
		int start = 0;
		if (head < tail) {
			for (int i = head; i < tail; i++) {
				newQ[start] = q[i];
				start++;
			}
		} else {
			for (int i = head; i < q.length; i++) {
				newQ[start] = q[i];
				start++;
			}
			for (int i = 0; i < tail; i++) {
				newQ[start] = q[i];
				start++;
			}
		}
		tail = size();
		head = 0;
		q = newQ;
	}
	
	public String dequeue() {
		if (isEmpty()) return null;
		else {
			if (queueSize < q.length / 4) {
				resize(q.length / 2);
			}
			String item = q[head];
			q[head] = null;
			head = (head + 1) % q.length;
			queueSize--;
			return item;
		}
	}
	
	public int size() {
		return queueSize;
	}
	
	public boolean isEmpty() {
		return q[head] == null;
	}
	
	public String printQueue() {
		String output = "";
		for (int i = 0; i < q.length; i++) {
			output += q[i] + " ";
		}
		return output;
	}
	
}
