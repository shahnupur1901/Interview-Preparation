


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int t[][] = new int[n+1][sum+1];
	    t[0][0] = 1;
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<sum+1;j++){
	            if(j==0) t[i][0] = 1;
	            if(i==0 && j!=0) t[0][j] = 0;
	        }        
	    }
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<sum+1;j++){
            //current item less or equal to that sum j
	            if(arr[i-1] <= j){
                //if this current item is included,without it, how many subsets are possible at a place where weight-wtOfCurrentElement 
	                int included = t[i-1][j-arr[i-1]];
                //current item not included, then cell above current
	                int excluded = t[i-1][j];
                //add all possible subsets
	                t[i][j] = (included+excluded)%1000000007;
	            }
	            else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	  return t[n][sum];  
	} 
}
