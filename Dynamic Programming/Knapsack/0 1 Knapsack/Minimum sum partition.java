/*
Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 
*/
public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i=0;i<n;i++) sum=sum+arr[i];
	    //implementing subset sum for arr and sum = sumRange
	    boolean t[][] = new boolean[n+1][sum+1];
	    //possible to get 0 sum with 0 element array
	    t[0][0] = true;
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<sum+1;j++){
	            //sum > 0 not possible with 0 elements
	            if(i==0 && j!=0) t[i][j] = false;
	            //sum = 0 possible with any number of elements with empty set
	            if(j==0) t[i][j] = true;
	        }
	    }
	    //Filling the array, knapsack style
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<sum+1;j++){
	            //if current element is less than sum at this stage, it may be possible to include it.
	            if(arr[i-1] <= j){
	                boolean included = t[i-1][j-arr[i-1]];
	                boolean excluded = t[i-1][j];
	                t[i][j] = included || excluded;
	            }
	            else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	    
	    //Finding maximum S1 which is in (0, range/2]
	    int max = Integer.MIN_VALUE;
	    for(int x = 0;x<=sum/2;x++){
	        //System.out.print(t[n][x]+" ");
	        if(t[n][x]==true) max = Integer.max(max, x);
	    }
	    
	    int s1 = max;//highest sum in the first half
	    int s2 = sum - s1;
	    int mindifference = s2-s1;
	    return mindifference;
	    
	} 
