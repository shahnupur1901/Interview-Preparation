/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
1. Reverse the array
2. Reverse 0 to k-1
3. Reverse k to len - 1

123456  3
654321
456321
456123
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    void reverse(int low, int high, int[] nums){
        for(int i=low, j=high ; i<j ;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
