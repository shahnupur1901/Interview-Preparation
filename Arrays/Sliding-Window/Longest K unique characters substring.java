class Solution {
    public int longestkSubstr(String s, int k) {
    //map to keep element and count 
       HashMap<Character, Integer> map = new HashMap();
       int i=0, j=0, maxsize=-1;
       while(j<s.length()){
           // place character in map
           map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
           //map and window doesn't contain k unique characters
           if(map.size() < k) j++;
           //window contains k unique
           else if(map.size() == k) {
               maxsize = Integer.max(maxsize, j-i+1);
               j++;
           }
           //window contains > k unique characters
           else if(map.size() > k){
               while(map.size() > k && i<s.length()){
                   //getting rid of i elements till k unique are present
                   map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)-1);
                   if(map.get(s.charAt(i)) <= 0) map.remove(s.charAt(i));
                   i++;
               }
               j++;
           }
       }
       return maxsize;
    }
}
