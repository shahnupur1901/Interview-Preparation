class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    
    static boolean twosum(ArrayList<Integer> a, int sum){
        int i = 0, j = a.size()-1;
       // System.out.println(a);
        while(i<j){
            int csum = a.get(i) + a.get(j);
            if(csum == sum) return true;
            if(csum < sum) i++;
            else j--;
        }
        return false;
    }
    
    public static boolean find3Numbers(int arr[], int n, int sum) { 
    
       // Your code Here
       Arrays.sort(arr);
       for(int i=0;i<n;i++){
           ArrayList<Integer> a = new ArrayList<Integer>();
           for(int x : arr){
               a.add(x);
           }
           // a.set(i, Integer.MAX_VALUE);
           a.remove(i);
           // System.out.println(sum - arr[i]);
           if(twosum(a, sum-arr[i])) return true;
       }
       return false;

       
    
    }
}
