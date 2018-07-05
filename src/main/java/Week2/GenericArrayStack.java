package Week2;

public class GenericArrayStack<Item> {
	private Item[] s;
	private int last = 0;
	
	public GenericArrayStack(int capacity) 
	{	s = (Item[]) new Object[capacity]; }
	
	public boolean isEmpty() 
	{	return last == 0; }
	
	public void push(Item item) 
	{	s[last++] = item; }
	
	public Item pop() 	{	
		if (last == 0) { return null; }
		return s[--last];	
	}
	
}
