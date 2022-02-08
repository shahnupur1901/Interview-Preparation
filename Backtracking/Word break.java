/*
Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. 
Each dictionary word can be used more than once. Return all such possible sentences.
Input: s = "catsanddog", n = 5 
dict = {"cats", "cat", "and", "sand", "dog"}
Output: (cats and dog)(cat sand dog)
Explanation: All the words in the given 
sentences are present in the dictionary.

Idea : Keep p & up strings. If up size = 0, exit and return p.
Else, 
In the up string, check if substring is a plausible word (in dictionary). Up can be broken using a for loop with n (up.length) iterations
eg : up = abc : substring : a|bc, ab|c, abc|
If plausible, include substring in processed p string and continue.
else go to next substring
*/
class Solution{
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        
        return breaking(dict, "", s);
    }
    static List<String> breaking(List<String> dict, String p, String up){
        if(up.length()==0){
            ArrayList<String> a = new ArrayList<>();
            a.add(p);
            return a;
        }
        ArrayList<String> b = new ArrayList<>();
        for(int i=1;i<=up.length();i++){
            String word =  up.substring(0, i);
            if(dict.contains(word)){
                if(p.length()!=0)
                b.addAll(breaking(dict, p +" "+word, up.substring(i)));
                else{
                    b.addAll(breaking(dict, p +word, up.substring(i)));
                }
            }
        }
        return b;
    }
}
