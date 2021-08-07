/*
  1. Subset list is created with size as nums, and initiated with null.
  2. Helper function takes array nums, index idx, and subset array.
  3. In helper :
    a) if idx==nums : done. Print it out.
    b)
      1. idx index = null.
      Call helper for such, and create a subset
      2. idx index = arr[idx]
      Call helper for such, and create a subset.
      
  4. Your input
[1,2,3]
Subsets : 
[null, null, null]
[null, null, 3]
[null, 2, null]
[null, 2, 3]
[1, null, null]
[1, null, 3]
[1, 2, null]
[1, 2, 3]
*/

class Solution {
    public void subsets(int[] nums) {
          List<Integer> subset = new ArrayList(nums.length);
	        for(int i=0;i<nums.length;i++){
	            subset.add(null);
	        }
	        
	        helper(nums,0,subset);
    }
     void helper(int[] nums, int idx,List<Integer> subset ){
	        if(idx==nums.length){
	           System.out.println(subset);
	        }
	        else{
	            subset.set(idx,null);
	            helper(nums,idx+1,subset);
	            subset.set(idx,nums[idx]);
	            helper(nums,idx+1,subset);
	        }
	    }
    
}
