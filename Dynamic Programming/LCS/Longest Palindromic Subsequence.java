public int longestPalinSubseq(String S)
    {
        //LCS of string a and a.reverse is the LPS!
        String x = new String(S);
        StringBuffer y1 = new StringBuffer(x);
        y1.reverse();
        String y = y1.toString();
        int n = x.length();
        int t[][] = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            t[i][0] = 0;
            t[0][i] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Integer.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][n];
    }
