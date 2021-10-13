

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int t[][] = new int[n+1][W+1];
         for(int i = 0;i<=n;i++){
             Arrays.fill(t[i],-1);
         }
         return rKnapsack(W,wt,val,n,t);
         
    } 
       static int rKnapsack(int w, int wt[], int val[], int n, int[][] t){
        if(n<=0 || w<=0){
          t[n][w] = 0;
        }
        if(t[n][w] != -1){
            return t[n][w];
        }
        if(wt[n-1] > w){
            
            t[n][w] = rKnapsack(w,wt,val,n-1,t);
        }
        else{
            t[n][w] =  Integer.max(rKnapsack(w,wt,val,n-1,t), val[n-1] + rKnapsack(w - wt[n-1],wt,val,n-1,t));
        }
        return t[n][w];
    }
}
