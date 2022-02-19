class Solution {
    public long count(int coin[], int n, int sum) {
        // code here.
        long t[][] = new long[coin.length+1][sum+1];
        t[0][0] = 1;
        for(int i=0;i<coin.length+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0)t[i][j]=1;
                if(i==0 || j!=0) t[0][j]=0;
            }
        }
        for(int i=1; i<coin.length+1; i++){
            for(int j=1;j<sum+1; j++){
                if(coin[i-1] <=  j){
                    t[i][j] = t[i-1][j] + t[i][j-coin[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][sum];
    }
}
