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
/*
Tabulation :
size : target + 1
if target == 0, true. so table[0] = true
make each accessible solution true
*/
class Solution {
    public boolean canSum(int[] nums, int target) {
        boolean[] table = new boolean[target+1];
        Arrays.fill(table,false);
        table[0] = true;//target = 0 implies you can get it with no number
        for(int i=0;i<table.length;i++){
            if(table[i]==false)
                continue;
            else{
                for(int j : nums){
                    if(i+j<target+1) table[i+j] = true;
                }
            }
        }
        return table[target];
       
      
    }
   
}
