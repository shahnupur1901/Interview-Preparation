  static int recursiveKnapsack(int w, int wt[], int val[], int n){
        //All items explored and the knapsack has no remaining capacity, return profit at that point as 0;
       if(n<=0 || w<=0){
           return 0;
       }
    //Current item weight greater than remaining capacity
       if(wt[n-1] > w){
           int wtGreater = recursiveKnapsack(w, wt, val, n-1);
           return wtGreater;
       }
       //Current item weight less/equal than remaining capacity
       else{
         //Current item included
           int wtIfIncluded = val[n-1] + recursiveKnapsack(w-wt[n-1], wt, val, n-1);
         //Current item not included
           int wtNotIncluded = recursiveKnapsack(w, wt, val, n-1);
         //return max profit
           return Integer.max(wtIfIncluded, wtNotIncluded);
       }
    }
