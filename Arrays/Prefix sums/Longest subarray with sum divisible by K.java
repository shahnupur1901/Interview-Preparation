int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        // Complete the function
        int maxlen=0, i=0,j=0, sum=0, soln=0;
        HashMap<Integer, Integer> map = new HashMap();
        while(i<n){
           sum = sum + arr[i];
           soln = sum%k;
           if(soln < 0) soln = soln + k;
           if(soln%k == 0){
               maxlen = Integer.max(maxlen, i+1);
               i++;
               continue;
           }
           if(!map.containsKey(soln)) map.put(soln, i);
           else if(map.containsKey(soln)){
               int x = map.get(soln);
               maxlen = Integer.max(maxlen, i-x);
           }
           i++;
         
        }
        return maxlen;
       
    }
 
}
