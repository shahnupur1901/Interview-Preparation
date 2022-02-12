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
        return partition(arr, N, 0, requiredSum)?1:0;
        
    }
    static boolean partition(int[] arr, int n,int idx, int sum){
       if(sum==0) return true;
       if(idx == n) return false;
        boolean x  = partition(arr, n, idx+1,sum);
        boolean y  = partition(arr, n, idx+1,sum - arr[idx]);
        return x || y;
    }
    }
