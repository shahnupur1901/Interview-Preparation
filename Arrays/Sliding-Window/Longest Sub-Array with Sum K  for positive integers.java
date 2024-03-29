// Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        //Complete the function
        int i=0,j=0;
        int sum = 0, maxsize = 0;
        while(j<n){
            sum = sum + arr[j];
            if(sum < k) j++;
            else if (sum==k){
                maxsize = Integer.max(j-i+1,maxsize);
                j++;
            }
            else if(sum > k){
                while(sum > k && i<n){
                    sum = sum - arr[i];
                    i++;
                }
                if(sum == k) {
                    maxsize = Integer.max(j-i+1,maxsize);
                }
                j++;
            }
        }
        return maxsize;
    }
    
