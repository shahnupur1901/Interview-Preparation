/*
2 pointer solution 
-sort
-use i and j
O(nlogn)
*/
class Solution {
    public boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int i = 0,j=nums.length-1;
        while(i<=j){
            if(nums[i]+nums[j]==target){
                return true;
            }
           else if(nums[i]+nums[j]<target)
            i++;   
            else
                j--;
            
        }
              return false;
    }
}
/*
Hash Table solution
check complement
add in table if necessary
O(n) Time complexity
O(n) space complexity
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                ans[0] = map.get(complement);
                ans[1] = i;
                return ans;
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
                
            }
        }
        return ans;
    }
}
