/*
Keep 2 stacks 1 - normal, other for minimums
*/
class MinStack {
      Stack<Integer> stack;
        Stack<Integer> mstack;
        int top;

    /** initialize your data structure here. */
    public MinStack() {
        Stack<Integer> stack = new Stack();
        Stack<Integer> mstack = new Stack();
        int top = -1;
    }
    
    public void push(int val) {
        if (mstack.isEmpty() )
        {
            mstack.push(val);
        
        }
        stack.push(val);
        if(val < mstack.peek()){
            mstack.push(val);
        }
        
    }
    
    public void pop() {
        if(stack.peek()==mstack.peek()){
            stack.pop();
            mstack.pop();
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
