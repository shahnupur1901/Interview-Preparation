class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    while(!q1.isEmpty()){
	        q2.add(q1.poll());
	    }
	    q1.add(a);
	    while(!q2.isEmpty()){
	        q1.add(q2.poll());
	    }
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    if(q1.isEmpty()) return -1;
	    else return q1.poll();
    }
	
}

