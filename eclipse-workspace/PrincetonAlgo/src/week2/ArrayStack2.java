package week2;

public class ArrayStack2 {
	
	private String[] s;
	
	//Starts at 0, unlike my implementation that started at -1
	private int N = 0;
	
	//cheat -- client shouldn't need to keep track of the size.
	public ArrayStack2(int capacity) 
	{	s = new String[capacity]; }
	
	public boolean isEmpty() 
	{	return N == 0; }
	
	//shortcut -- use index, then increment.
	public void push(String item) 
	{	s[N++] = item; }

//Looks like in an absolute sense, the data stays in the array (loitering).  But because there is no way to access it, we keep our place using N and just overwrite as we go. All that matters is that pop returns the right item, and push adds in the right place. Notice that N is always one ahead of the last pushed element. That's why we have to decrement first.
	
	public String pop()
	{
		//fix this loitering problem to save memory		
		//return S[--N]
		String item = s[--N];
		s[N] = null;
		return item;
	} 
}
