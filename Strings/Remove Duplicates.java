/*
String only contains lowercase English letters- > hint take arr of size 26
Make it contain frequency of each char
Traverse the str again, and if != -1 append and make -1 else continue 
*/
class Solution {
    String removeDups(String s) {
        // code here
        int arr[] = new int[26];
        Arrays.fill(arr,0);
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i) - 'a'] != -1){
            ans = ans.concat(s.charAt(i) +"");
            arr[s.charAt(i) - 'a'] = -1;
            }
            else
            continue;
        }
        return ans;
    }
}
