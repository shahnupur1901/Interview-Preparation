public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
  // First ------> Queue vibes
        Queue<Long> l = new LinkedList();
        long[] ans = new long[n-k+1];
        int ansidx = 0;
        int i=0, j=0;
        while(j<n){
            if(arr[j] < 0) l.add(arr[j]);
            if(j-i+1 < k) j++;
            else {
                if(l.isEmpty()) ans[ansidx] = 0;
                else ans[ansidx] = l.peek();
            
            if(!l.isEmpty() && arr[i] == l.peek()) l.poll();
            i++;
            j++;
            ansidx++;
            }
        }
        return ans;
    }
