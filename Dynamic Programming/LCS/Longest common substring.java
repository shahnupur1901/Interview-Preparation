class Solution{
    int longestCommonSubstr(String x, String y, int n, int m){
        // code here
        int t[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
      // the value at i, j represents : the length of the maximum common substring which ends with the character at position i-1, or j-1 as both characters are the same.
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
              // same characters at the end
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
              //different characters, thus, the length of CS with ending as these characters will be zero
                else{
                    t[i][j]=0;
                }
            }
        }
      //Finding the max length substring
        int max = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                max = Integer.max(max, t[i][j]);
            }
        }
        return max;
        
    }
}
