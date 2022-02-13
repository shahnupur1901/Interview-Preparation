static void permutation(String permutation, String str){
	    if(str.length()==0){
	        System.out.println(permutation);
	        return;
	    }
	    int permutationCalls = permutation.length() + 1;
	    for(int i=0;i < permutationCalls;i++){
	        permutation(permutation.substring(0,i) + str.charAt(0) + permutation.substring(i, permutation.length()), str.substring(1));
	    }
	}
	
