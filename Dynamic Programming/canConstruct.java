/*
Construct word from the list of words -> true if possible else not
'' empty string can be always constructed by doing nothing.
*/
/*
m = target string
n = word dict len - height of tree
Brute force soln : 
Time : O(n^m * m)
Space : O(m*m)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return canConstruct(s,wordDict);
    }
    boolean canConstruct(String s, List<String> wordDict){
        if(s.equals(""))
            return true;
        for(String word : wordDict){
            if(s.indexOf(word)==0){
                if(canConstruct(s.substring(word.length(), s.length()),wordDict))
                    return true;
            }
        }
        return false;
    }
}
/*
Memoized solution
T : O(n*m*m)

*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return canConstruct(s,wordDict, new HashMap<String,Boolean>());
    }
    boolean canConstruct(String s, List<String> wordDict, HashMap<String,Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.equals(""))
            return true;
        for(String word : wordDict){
            if(s.indexOf(word)==0){
                if(canConstruct(s.substring(word.length(), s.length()),wordDict,map)){
                    map.put(s, true);
                    return true;
                }
            }
        }
         map.put(s, false);
        return false;
    }
}
