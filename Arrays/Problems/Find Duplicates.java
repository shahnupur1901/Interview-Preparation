class Solution {
    public int findDuplicateNegativeMarking(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int num = nums[Math.abs(nums[i])];
            if(num < 0) return -1 * nums[i];
            nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
            print(nums);
        }
        return -1;
    }
    void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] +" ");       
        }
        System.out.println();
    }
     public int findDuplicate(int[] nums) {
        
    }
    
    
}
