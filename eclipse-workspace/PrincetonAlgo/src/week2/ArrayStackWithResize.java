package week2;

public class ArrayStackWithResize {
	private String[] stack;
	private int position = 0;

	public ArrayStackWithResize() {
		//start at 2, otherwise the squaring operation won't work!
		//or just double and start at 1
		stack = new String[1];
	}
	
	public int getLength() {
		return stack.length;
	}
	
	public boolean isEmpty() {
		return position == 0;
	}
	
	public void resizeArray(int newSize) {
		int stackSize = getLength();
		String[] copy = new String[newSize];
		for (int i = 0; i < Math.min(stackSize, newSize); i++) {
			copy[i] = stack[i];
		}
		stack = copy;
		
//		This is a little too expensive -- we don't have to make so many copies.
//		String[] stackCopy = stack;
//		stack = new String[newSize];
//		for (int i = 0; i < stackSize; i++) {
//			stack[i] = stackCopy[i];
//		}
	}
	
//We have to recreate the array as a new array of length n^2 when we reach n. I will copy by hand, iterating through the array, rather than using any built in methods (which probably do the same thing). Creating a dummy array to hold the reference may take O(n), creating a new array another O(n), and copying another O(n) -- so I would think this is O(3n) = O(n).
	
//Actually, squaring is a bit overkill -- only needs to be doubled.

	public void push(String item) {
		int stackSize = getLength();
		
//		The idea is to refactor this by creating a new method.
//		if (position + 1 < stackSize) {
//			stack[position++] = item;			
//		} else {
//			String[] stackCopy = stack;
//			stack = new String[stackSize*2];
//			for (int i = 0; i < stackCopy.length; i++) {
//				stack[i] = stackCopy[i];
//			}
//			stack[position++] = item;
//		}
		
		if (position == stackSize) resizeArray(2*stackSize); 
		stack[position++] = item;
		
	}
	
	public String pop() {
		int stackSize = stack.length;
		if (position == stackSize/4) resizeArray(stackSize/2);
		String item = stack[--position];
		stack[position] = null;
		return item;
	}
	
	public static void main(String[] args) {
		ArrayStackWithResize stack = new ArrayStackWithResize();
		stack.push("Hello");
		stack.push("World!");
		stack.push("This");
		stack.push("Is");
		stack.push("A");
		stack.push("Test!");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push("Hello");
		stack.push("World!");
		stack.push("This");
		stack.push("Is");
		stack.push("A");
		stack.push("Test!");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
	
}
