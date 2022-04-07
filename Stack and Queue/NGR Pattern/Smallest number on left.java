class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
       ArrayList<Integer> answer = new ArrayList();
        Stack<Integer> stack = new Stack();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()) answer.add(-1);
            else{
                while(!stack.isEmpty() && stack.peek() >= a[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()) answer.add(stack.peek());
                else answer.add(-1);
            }
            stack.add(a[i]);
            
        }
        return answer;
    }
}
