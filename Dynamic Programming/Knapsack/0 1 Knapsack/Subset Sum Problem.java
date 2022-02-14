  static Boolean isSubsetSum(int N, int arr[], int sum){
        // Creating a matrix of rows = N+1 and cols = sum+1
        boolean t[][] = new boolean[N+1][sum+1];
        //Element with indices i, j shows if subsetsum is possible with the first i elements of arr and sum of j
        //Initialization
        for(int i=0;i<N+1;i++){
            for(int j=0;j<sum+1;j++){
                //Its possible to create a subset with 0 elements of sum 0, i.e. empty subset
                if(i==0 && j==0) t[0][0] = true;
                //First column, implies zero sum, implies an empty set which is a subset of each set. Thus its possible
                if(j==0) t[i][0] = true;
                //First row, implies zero elements, and no sum other than 0 is possible
                if(i==0 && j!=0) t[i][j] = false;
            }
        }
        
        //Solving it
        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                //if current item <= sum
                if(arr[i-1] <= j){
                    boolean included = t[i-1][j - arr[i-1]];
                    boolean excluded = t[i-1][j];
                    t[i][j] = included || excluded;
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][sum];
    }
