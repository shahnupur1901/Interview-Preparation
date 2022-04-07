class GfG{
    Stack<Integer> ss = new Stack();
	public void push(int a,Stack<Integer> s)
	{
	    s.add(a);
	    if(ss.size()==0 || ss.peek() > a) ss.add(a);
	}
	public int pop(Stack<Integer> s)
        {
            if (isEmpty(s)) return -1;
            int x = s.pop();
            if(x == ss.peek()) ss.pop();
            return x;
	}
	public int min(Stack<Integer> s)
        {
           return ss.peek();
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           if(s.size() == n) return true;
           else return false;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           if(s.size() == 0) return true;
           else return false;
	}
}
