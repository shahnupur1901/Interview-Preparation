/*
Approach :
do 2 searches for first and last with diff functions
for the first :
when arr[mid]==target :
update minidx;
high = midpt - 1
continue searching

for the last:
when arr[mid]==target :
update minidx;
low = midpt + 1
continue searching
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = searchFirst(nums,target,0,nums.length-1,0);
        res[1] = searchEnd(nums,target,0,nums.length-1,0);
        return res;
        
    }
    public int searchFirst(int[] arr, int target,int low,int high,int res){
        if(low>high) return res;
        int midpt = low + (high - low)/2;
        if(arr[midpt]==target){
            high = midpt - 1;
            res++;
            return searchFirst(arr,target,low,high,res);
        }
        else if(arr[midpt]>target){
        high = midpt - 1 ;
        return searchFirst(arr,target,low,high,res);
        }
        else{
            
            return searchFirst(arr,target,midpt+1,high,res);
            
        }
    }
     public int searchEnd(int[] arr, int target,int low,int high,int res){
        if(low>high) return res;
        int midpt = low + (high - low)/2;
        if(arr[midpt]==target){
            low = midpt + 1;
            res++;
            return searchEnd(arr,target,low,high,res);
        }
        else if(arr[midpt]>target){
        high = midpt - 1 ;
        return searchEnd(arr,target,low,high,res);
        }
        else{
            
            return searchEnd(arr,target,midpt+1,high,res);
            
        }
     }
}
