/*
m = target sum
n = length of array
Brute force :
Time complexity : O(n^m)
Space complexity : O(m) space
New : 
T : O(m*n)
Space : O(m)
*/
   public boolean canSum(int[] nums, int target, HashMap<Integer,Boolean> map){
        if(map.containsKey(target))
            return map[target];
        if(target==0)
            return true;
        if(target < 0)
            return false;
        for(int num : nums){
            int remainder = target - num;
            if(canSum(nums, remainder)){
                map.put(target,true);
                return true;
            }
        }
        map.put(target,false);
        return false;
    }
}
