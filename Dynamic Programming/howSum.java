/*
Brute Force
Diff from 2 sum as sum can be of any number of operands amounting to targetsum
T : O(n^m *m)
S : O(m)
*/
public ArrayList<Integer> canSum(int[] nums, int target){
        if(target==0)
            return new ArrayList();
        if(target < 0)
            return null;
        for(int num : nums){
            int remainder = target - num;
            ArrayList<Integer> a = canSum(nums, remainder);
            if(a!=null){
              a.add(num);
              return a;
        }
       return null;
    }
}
/*
Memoized
Diff from 2 sum as sum can be of any number of operands amounting to targetsum
T : O(n*m *m)
S : O(m*m)
*/
public ArrayList<Integer> canSum(int[] nums, int target, HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0){
            
            return new ArrayList();
        }
        if(target < 0){
            return null;
        }
        for(int num : nums){
            int remainder = target - num;
            ArrayList<Integer> a = canSum(nums, remainder);
            if(a!=null){
              a.add(num);
              memo.put(target, a)
              return a;
        }
          memo.put(target,null);
       return null;
    }
}
