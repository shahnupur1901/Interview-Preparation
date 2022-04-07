The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate 
the span of stocks price for all n days. 
The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, 
for which the price of the stock on the current day is less than or equal to its price on the given day.
  
 So basically, find the greatest element to the left with idx i, then num of small/equal days = currentidx - i
 Keep left most index as -1 if there is no element greater that current element
 
 class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int answer[] = new int[n];
        Stack<Integer> s = new Stack();
        for(int i=0;i<n;i++){
            if(s.isEmpty()) answer[i] = 1;
            else{
                while(!s.isEmpty() && price[s.peek()] <= price[i]){
                    s.pop();
                }
                int greatestidx;
              if(s.isEmpty()) greatestidx = -1;
              else{
                  greatestidx = s.peek();
              }
               answer[i] = i - greatestidx;
            }
            s.add(i);
        }
        
        return answer;
    }
    
}
