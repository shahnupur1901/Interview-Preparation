/*
IMP : midpt = start + (end-start)/2       ------>    integer overflow problems
low<=high
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }
    public int search(int arr[],int target,int low,int high){
        if (low<=high){
        int midpt = (low+high)/2;
        if(arr[midpt] > target){
            return search(arr,target,low,midpt-1);
        }
        else if(arr[midpt] == target)
            return midpt;
        else
            return search(arr,target,midpt+1,high);
        }
        else
            return -1;
        }      
}
