 public static int shortestCommonSupersequence(String X,String Y)
    {
        //Your code here
        int n = X.length();
        int m = Y.length();
        int t[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Integer.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int lenLCS = t[n][m];
        int lenSCS = n + m - lenLCS;
        return lenSCS;
    }
