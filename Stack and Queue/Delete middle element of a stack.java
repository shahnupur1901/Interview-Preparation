class Solution
{
    //Function to delete middle element of a stack.
    void popmid(Stack<Integer> s, int size, int currentidx){
        if(currentidx == size/2){
            s.pop();
            return;
        }
        int x = s.pop();
        popmid(s,size,currentidx+1);
        s.add(x);
        return;
    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        popmid(s,sizeOfStack,0);
    } 
}
