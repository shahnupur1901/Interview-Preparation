/*
Approach :
1. Keep 1 loop for the length of the substring from s.length - 1 to 0
2. Keep another loop for the starting idx o the substring
As we are starting with largest len return first palindrome
*/
class Solution {
    public String longestPalindrome(String s) {
       if(isPalindrome(s)) return s;
      
        for(int len = s.length();len>0;len--){
            for(int i = 0; i+len<=s.length();i++){
                String str = s.substring(i,i+len);
                if(isPalindrome(str)){ 
                    return str;
                }
            }
        }
        return s;
        
    }
    public boolean isPalindrome(String s){
        for(int i = 0,j=s.length()-1 ; i<j ; i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
            
    }
}
