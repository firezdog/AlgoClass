package week2;

public class FixedCapacityStackOfStrings {
	
	private String[] strings;
	private int lastIndex;
	
	public int getLastIndex() {
		return lastIndex;
	}
	
	public String[] getStrings() {
		return strings;
	}
	
	public FixedCapacityStackOfStrings(int n) {
		strings = new String[n];
		lastIndex = -1;
	}
	
	public void push(String item) {
		if (lastIndex == strings.length -1) {
			System.out.println("Stack is full.");
			return;
		}
		lastIndex += 1;
		strings[lastIndex] = item;
	}
	
	public String pop() {
		if (lastIndex < 0) {
			System.out.println("The stack is empty.");
			return "";
		} else {
			String popped = strings[lastIndex];
			strings[lastIndex] = null;
			lastIndex -= 1;
			return popped;			
		}
	}
	
	public static void main(String[] args) {
		//initialize a new stack of length 2
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
		
		//test that pop prints "stack is empty"
		stack.pop();
		
		//push some stuff
		stack.push("to");
		stack.push("be");
		
		//check that too many pushes prints "stack is full"
		int lastIndex = stack.getLastIndex();
		String[] strings = stack.getStrings();
		//System.out.println(lastIndex + " / " + (stack.strings.length-1));
		stack.push("or");
		
		//empty stack and print contents
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.pop();
	}

}