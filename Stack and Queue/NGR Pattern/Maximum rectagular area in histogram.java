Creating histograms (total = num of rows) with addition of each row.
Histograms are bounded by smaller heighted towwers on both sides found by nsr and nsl.
  Thus the total unit width = nsr[i] - nsl[i] - 1
  Area = width * height[i]
Find accordingly




class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long x) 
    {
        // Your code here
        int n = (int) x;
         long expandable[] = new long[n];
        long[] nsrArr = nsr(arr, n);
        long[] nslArr = nsl(arr, n);
        for(int i=0;i<n;i++){
            expandable[i] = nsrArr[i] - nslArr[i] - 1;
            //System.out.println(nslArr[i]+" "+expandable[i]);
        }
        long[] areas = new long[n];
        long max = 0;
        for(int i=0;i<n;i++){
            areas[i] = expandable[i] * arr[i];
            max = Long.max(max, areas[i]);
        }
        return max;
        
    }
    
    
    //nearest smallest to the right
    //if empty, that is all are greater : (n-1) +1 index
    static long[] nsr(long arr[], int n){
        Stack<Integer> s = new Stack();
        long ans[] = new long[n]; 
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()) ans[i] = n;
            else{
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()) ans[i] = n;
                else ans[i] = s.peek();
            }
            s.add(i);
        }
        return ans;
    }
    
       //nearest smallest to the left
    //if empty, that is all are greater : -1 index
    static long[] nsl (long arr[], int n){
        Stack<Integer> s = new Stack();
        long ans[] = new long[n]; 
        for(int i=0;i<n;i++){
            if(s.isEmpty()) ans[i] = -1;
            else{
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()) ans[i] = -1;
                else ans[i] = s.peek();
            }
            s.add(i);
        }
        return ans;
    }
        
}



