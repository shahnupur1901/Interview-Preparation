class Solution {
    public void nextPermutation(int[] nums) {
            int flag = 0;
           for(int i=0;i<nums.length-1;i++){
               if(nums[i] < nums[i+1]){
                   flag = 1;  break;
               }
           }
               if(flag == 0){
                   reverse(nums,0,nums.length-1);return;
               }
                int x = 0;
               for(int i=nums.length-1;i>=0;i--){
                   if(nums[i-1] < nums[i]){
                       x = i-1; break;
                   }
               }
        System.out.println(x);
        int y = 0;
                for(int i=x;i<nums.length;i++){
                    if(i+1==nums.length || nums[i+1] <= nums[x]){
                        y = i;
                         System.out.println(y);
                        swap(nums, x,y);
                        reverse(nums,x+1,nums.length-1 );
                        break;
                    }
                }
        
               
           }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
     void reverse (int[] arr, int l, int r){
        for(int i=l, j=r;i<j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
     }
}
