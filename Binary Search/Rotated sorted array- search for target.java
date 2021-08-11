/*
Approach : 
1. Find min idx
2. Get 2 sorted array
3. Normal binary search
*/
class Solution {
    public int search(int[] nums, int target) {
     int minidx = 0;
        int n = nums.length;
    int low = 0, high = nums.length - 1;
        if(nums[0] < nums[n-1]) minidx = 0;
        else{
        while(low<=high){
            int mid = low + (high - low)/2;
            int prev = (mid - 1 + n)%n;
            int next = (mid +1)%n;
            if(nums[mid] < nums[prev] && nums[mid] < nums[next] ){
                minidx = mid;
                break;
            }
            else if(nums[0] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        }
        int x = binary(nums,0,minidx-1,target);
        int y = binary(nums,minidx, n-1, target);
        if(x==-1 && y==-1) return -1;
        else
            return x!=-1 ? x : y;
    }
    int binary(int []nums, int low, int high, int target){
        int mid = low + (high-low)/2;
        if(low>high) return -1;
        else if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target){
            low = mid +1;
            return binary(nums,low,high,target);
        }
        else{
            high = mid - 1;
            return binary(nums, low, high, target);
        }
        
    }
}
