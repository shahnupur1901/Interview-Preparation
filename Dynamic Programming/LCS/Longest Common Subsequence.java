class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] t  = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length()+1;i++){
            for(int j=0;j<text2.length()+1;j++){
                t[i][j] = -1;
            }
        }
        //return memoizationLCS(text1, text2, text1.length(), text2.length(), t);
        return tabulationLCS(text1, text2);
    }
    int recursiveLCS(String x, String y, int n, int m){
      //smallest valid input is empty string
        if(n==0 || m==0) return 0;
      //if both characters a the end of string are same, decrease both by 1
        if(x.charAt(n-1) == y.charAt(m-1)){
            return 1 + recursiveLCS(x,y,n-1, m-1);
        }
      //else, find the LCS if the last char of one is removed, and compare when last char of other is removed.
        else{
            return Integer.max(recursiveLCS(x,y,n-1,m), recursiveLCS(x,y,n, m-1));
        }
    }
    int memoizationLCS(String x, String y, int n, int m, int[][] t){
        if(n==0 || m==0){
            t[n][m] = 0;
            return t[n][m];
        }
         if(t[n][m]!=-1)
            return t[n][m];
        if(x.charAt(n-1) == y.charAt(m-1)){
            t[n][m] = 1 + memoizationLCS(x, y, n-1, m-1, t);
            return t[n][m];
        }
        else{
            t[n][m] = Integer.max(memoizationLCS(x, y, n, m-1, t), memoizationLCS(x, y, n-1, m, t));
            return t[n][m];
        }
    }
    
    int tabulationLCS(String x, String y){
        int n = x.length();
        int m = y.length();
        int t[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                //If length of either string is zero, it implies that is no subsequence, ie, length of it is zero.
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Integer.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}
