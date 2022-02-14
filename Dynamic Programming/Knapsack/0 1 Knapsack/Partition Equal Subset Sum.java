class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int x : arr){
            sum = sum + x;
        }
        if(sum%2 != 0) return 0;
        int requiredSum = sum/2;
        return subsetSumPartition(arr, N, requiredSum);
        
    }
    static int subsetSumPartition(int[] arr, int n,int sum){
        int t[][] = new int[n+1][sum+1];
        t[0][0] = 1;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0) t[i][0] = 1;
                if(i==0 && j!=0) t[0][j] = 0;
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j){
                    t[i][j] = Integer.max(t[i-1][j], t[i-1][j - arr[i-1]]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
       
    }
    }
