class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int maxr[] = maxR(arr,n);
        int maxl[] = maxL(arr,n);
        int waterLevel[] = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            waterLevel[i] = Integer.min(maxr[i], maxl[i]) - arr[i];
            sum = sum + waterLevel[i];
        }
        return sum;
    }
    
    static int[] maxL(int arr[], int n){
        int max = 0;
        int maxL[] = new int[n];
        for(int i = 0;i<n; i++){
            max = Integer.max(max, arr[i]);
            maxL[i] = max;
            //System.out.println(maxL[i]);
        }
    return maxL;
        
    }
      static int[] maxR(int arr[], int n){
        int max = 0;
        int maxR[] = new int[n];
        for(int i = n-1;i>=0; i--){
            max = Integer.max(max, arr[i]);
            maxR[i] = max;
            //System.out.println(maxR[i]);
        }
    return maxR;
        
    }
        
}


