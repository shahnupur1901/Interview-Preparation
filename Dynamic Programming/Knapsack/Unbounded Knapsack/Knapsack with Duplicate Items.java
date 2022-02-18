class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
      //Same initialization
        int t[][] = new int[N+1][W+1];
        t[0][0] = 0;
        for(int i=0;i<N+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0) t[i][j] = 0; 
            }
        }
      //Same traversal
        for(int i=1;i<N+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1] <= j){
                  //Twist is here
                  //When u r including an element, you can take it again. So remain in the same row, i.e i, and subtract the current wt[i-1] to see the max profit 
                  //there and add it to the current profit val[i-1]
                    t[i][j] = Integer.max(t[i-1][j], val[i-1] + t[i][j-wt[i-1]]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[N][W];
    }
}
