A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the
party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means
ith person knows jth person. 
Here M[i][i] will always be 0.

Solve by ELIMINATION AND SUBSEQUENT CHECKING AND VERIFICATION
  
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here 
    	Stack<Integer> s = new Stack();
    	for(int i=0;i<n;i++){
    	    s.add(i);
    	}
    	while(s.size()>=2){
    	    int p1 = s.pop();
    	    int p2 = s.pop();
    	    //if person 1 knows person 2, person 1 can't be a celebrity.
    	    if(arr[p1][p2] == 1) s.add(p2);
    	    //If person 1 doesn't know person 2, person 2 can't be a celebrity.
    	    else s.add(p1);
    	}
        int p = s.pop();
        //Check if this person is a celebrity.
        for(int i=0;i<n;i++){
            //He shouldn't know anyone, so row should be 0.
            if(arr[p][i] == 1) return -1;
            //Everyone should know him, so col must be one. if i = j, val = 0. So mofifying condition
            if(i!=p && arr[i][p] ==0 ) return -1;
        }
        
        return p;
    }
}
