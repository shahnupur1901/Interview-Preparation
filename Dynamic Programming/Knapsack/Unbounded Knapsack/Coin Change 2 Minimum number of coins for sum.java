class Solution{

	public int minCoins(int coins[], int n, int sum) 
	{ 
	    // Your code goes here
	    int t[][] = new int[n+1][sum+1];
	    t[0][0] = 0;
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<sum+1;j++){
	            if(j==0) t[i][j] = 0;
	            if(i==0 && j!=0) t[i][j] = Integer.MAX_VALUE-1;
	        }
	    }
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<sum+1;j++){
	            if(coins[i-1] <= j){
	                t[i][j] = Integer.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
	            }
	            else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	    return t[n][sum]!=Integer.MAX_VALUE-1?t[n][sum] : -1;
	} 
}
