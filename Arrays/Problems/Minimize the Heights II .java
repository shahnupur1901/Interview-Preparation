class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        if(n==1) return 0;
        //Sort array
        Arrays.sort(arr);
        // Find the extreme elements.
        int a = arr[0];
        int b = arr[n-1];
        //Initialize min diff
        int diff = b - a;
        for(int i=0;i<n-1;i++){
            // Adjacent elements
            int x = arr[i];
            int y = arr[i+1];
            if(y - k < 0) continue;
            int max = Integer.max(b-k, x+k);
            int min = Integer.min(a+k, y-k);
            diff = Integer.min(diff, max - min);
        }
        return diff;
        
    }
}
