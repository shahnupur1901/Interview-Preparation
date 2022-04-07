
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code her
        Stack<Long> s = new Stack();
         long[] ans = new long[n];
         int idx = n-1;
        for(int i=n-1;i>=0;i--){
          //No such element present
            if(s.isEmpty()) ans[idx] = (long)-1;
            else{
                while(!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                if(!s.isEmpty()) ans[idx] = s.peek();
                else ans[idx] = -1;
                }
            idx--;
            s.add(arr[i]);
        }
         
          return ans;
    }
    
}
