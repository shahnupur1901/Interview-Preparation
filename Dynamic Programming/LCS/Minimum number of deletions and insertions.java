	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n = str1.length();
	    int m = str2.length();
	    int t[][] = new int[n+1][m+1];
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<m+1;j++){
	            if(i==0 || j==0) t[i][j] = 0;
	        }
	    }
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<m+1;j++){
	            if(str1.charAt(i-1) == str2.charAt(j-1)){
	                t[i][j] = 1+t[i-1][j-1];
	            }
	            else{
	                t[i][j] = Integer.max(t[i-1][j], t[i][j-1]);
	            }
	        }
	    }
	    int numDeletions = str1.length() - t[n][m];
	    int numInsertions = str2.length() - t[n][m];
	    return numDeletions+numInsertions;
	} 
