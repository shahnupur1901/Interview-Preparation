/*
Approach :

ALSO : To find the number of times rotated = index of min element
1. Check if array is already sorted, if so return first element
2. Sorted array rings bells for binary search.
- Set low, high and mid
-arr[mid] is smallest if it is less than both its neighbours
-Calculate prev and next while taking care of extreme conditions
-compare arr[mid] with the 0th element. If arr[0]<=arr[mid] ---> that is the latter sorted array, which is unwanted. so, low = midpt + 1;
-compare arr[mid] with the (n-1)th element. If arr[n-1]>arr[mid] ---> that is the latter sorted array, which is unwanted. so, high = midpt - 1;

O(log n)
0 1 2 3 4 5 6
4 5 6 7 0 1 2
low = 0 high = 6 mid = 3, arr[mid] = 7, neighbours are not bigger
compare with 4 and 2
4<=7 is true so low = 3+1=4

low=4 high = 6 mid = 5 arr[mid] = 1, neighbours not bigger
compare with 4 and 2
4<=1 is false
4>2 is true
so high = midpt - 1 = 4

0 is less than both neighbours so it is the min idx
*/
class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<=nums[nums.length-1]) return nums[0];
         int low = 0, high = nums.length - 1, mid = low + (high-low)/2;
        int n = nums.length;
        while(low<=high){
            mid = low + (high-low)/2;
            int prev = (mid - 1 + n)%n;//Take care of 0 and prevent unbounding
            int next = (mid + 1)%n;
            if(nums[mid] < nums[prev] && nums[mid]<nums[next]){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    }











