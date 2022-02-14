 
    static int tabulationKnapsack(int wt[], int profit[], int capacity){
        int n = wt.length;
        int w = capacity;
        int t[][] = new int[n+1][w+1];
        //initializing (analogous to base recursive relation)n->i & w->j
        for(int i=0;i<n+1;i++){//row traversal
            for(int j=0;j<w+1; j++){//col traversal
                if(i==0 || j==0) t[i][j] = 0;
            }
        }
        //choice diagram with iteration and substitue w as j and n as i
      //Don't learn this, get from recursive solution and substitute!
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1] <= j){
                    t[i][j] = Integer.max(profit[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
     }
