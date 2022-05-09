
    class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        //Complete the function
        //int i=0,j=0;
        int cursum = 0, maxsize = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0;i<n;i++){
            cursum = cursum + arr[i];
            if(cursum == k) maxsize = Integer.max(maxsize,i+1);
            if(!map.containsKey(cursum)) map.put(cursum,i);
            if(map.containsKey(cursum-k)) maxsize = Integer.max(maxsize,i-map.get(cursum-k));
        }
        return maxsize;
    }
    
    
}
