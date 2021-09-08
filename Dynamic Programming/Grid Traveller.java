/*
  * Top left to bottom right.
  When you move down, number of rows decreases by 1
  When you move to the right, number of columns decreases by 1.
  On a 1 by 1 grid, you reach, and its a success so return 1
  If you get a 0 dimension, it is a failure so return 1.
  Time Complexity without hashmap : T = O(2^m+n)
  Space Complexity : O(m+n)
  Time complexity With hashmap : O(m+n)
  Space : O(m+n)
  Why ? range of m = {0,...m} and similarly n.
  mC1 * nC1 = total number of possible combinations, as duplicates will not be recalculated.

*/
class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String,Integer> map = new HashMap();
       return paths(m,n, map);
        
    }
     public int paths(int m, int n, HashMap<String,Integer> map) {
    String s = Integer.toString(m) +" , "+ Integer.toString(n) ;
      String rev = Integer.toString(n)  +" , "+ Integer.toString(m) ;
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(map.containsKey(rev)){
            return map.get(rev);
        }
        if(m==1 && n==1) return 1;
        else if(m==0 || n==0) return 0;
         
        map.put(s, paths(m-1, n,map) + paths(m, n-1,map));
        return map.get(s);
        
    }
    
}
