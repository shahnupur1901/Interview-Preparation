
class Solution{
    static int longestSubstrDistinctChars(String str){
        // code here
        
        HashMap<Character, Integer> map = new HashMap();
        int maxsize = 0, i=0, j=0;
        while(j<str.length()){
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j),0)+1);
            // character repeated : 
            if(map.size() < j-i+1){
                while(i<str.length() && map.size() < j-i+1){
                     map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)-1);
                     if(map.get(str.charAt(i)) == 0) map.remove(str.charAt(i));
                     i++;
                }
                j++;
            }
            else if(map.size() == j-i+1){
                maxsize = Integer.max(maxsize, map.size());
                j++;
            }
            //map.size() > j-i+1 condition not possible as it cannot increase window size
            
        }
        return maxsize;
        
    }
}
