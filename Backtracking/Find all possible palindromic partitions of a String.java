/*Input:
S = "madam"
Output:
m a d a m
m ada m
madam
*/
class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> x = create(new ArrayList<String>(), S);
        return  x;
    }
  //Each arrayList in the answer is the palindromic substring
  //p is an arraylist which stores all palindromic substrings for this particular path so far
    static ArrayList<ArrayList<String>> create(ArrayList<String> p, String up){
        if(up.length()==0){
           //Nothing left to process. Answer arraylist added with all substrings in p arraylist
            ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
            ArrayList<String> np = new ArrayList();
            np.addAll(p);
            a.add(np);
            return a;
        }
        ArrayList<ArrayList<String>> b = new ArrayList<ArrayList<String>>();
        for(int i=1;i<=up.length();i++){
            if(isPalindrome(up.substring(0,i))){
                p.add(up.substring(0,i));
                String word = up.substring(0,i);
                b.addAll(create(p,up.substring(i)));
                p.remove(p.size()-1);
            }
        }
        //System.out.println(b);
        return b;
    }
    
    static boolean isPalindrome(String s){
        for(int i=0, j=s.length()-1 ; i<j; i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
};
