

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
         static int recursiveKnapsack(int w, int wt[], int val[], int n, int[][] t){
        //All items explored and the knapsack has no remaining capacity, return profit at that point as 0;
       if(n<=0 || w<=0){
           t[n][w] = 0;
           return 0;
       }
       if(t[n][w]!=-1) return t[n][w];
       if(wt[n-1] > w){
           int wtGreater = recursiveKnapsack(w, wt, val, n-1, t);
           t[n][w] = wtGreater;
           return wtGreater;
       }
       else{
           int wtIfIncluded = val[n-1] + recursiveKnapsack(w-wt[n-1], wt, val, n-1, t);
           int wtNotIncluded = recursiveKnapsack(w, wt, val, n-1, t);
           t[n][w] = Integer.max(wtIfIncluded, wtNotIncluded);
           return t[n][w];
       }
    }
}
