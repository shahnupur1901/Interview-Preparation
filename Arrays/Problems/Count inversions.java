class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return mergeSort(arr, 0,(int) N-1);
    }
    
    static long mergeSort(long arr[], int low,int high){
        long incnt = 0;
        if(low < high){
            int mpt = (low + high)/2;
            incnt += mergeSort(arr, low, mpt);
            incnt += mergeSort(arr, mpt+1, high);
            incnt += merge(arr, low, mpt, high);
        }
        return incnt;
        
    }
    
    static long merge(long arr[], int low, int mpt, int high){
        
        int i=low, j=mpt+1;
        long a[] = new long[arr.length];
        int idx = low;
        long inversionCnt = 0;
        while(i<=mpt && j<=high){
            if(arr[i] <= arr[j]){
                a[idx] = arr[i];
                idx++;
                i++;
            }
            //arr[j] < arr[i] : inversion condition
            // 5678 12
            // 5,6,7,8 > 1 thus, mpt = 3, i = 0, mpt + 1 - i = 4 = inversion count for first iteration.
            // if arr[j]<arr[i],  as arrs are sorted, all from (mpt+1) - i elements will be greater than arr[j]
            else{
                inversionCnt = inversionCnt + (mpt+1 - i);
                a[idx] = arr[j];
                idx++;
                j++;
            }
        }
        while(i<=mpt){
                a[idx] = arr[i];
                idx++;
                i++;
        }
        
         while(j<=high){
                a[idx] = arr[j];
                idx++;
                j++;
        }
        for(int y=low;y<=high;y++){
            arr[y] = a[y];
        }
        return inversionCnt;
    }
    
}

