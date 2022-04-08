
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        //initialization
        int i=0,j=0,maxsum=0, csum = 0;
        while(j<n){
            // Calculation part 1 with j
            csum = csum + arr.get(j);
          //Not reached window size
            if(j-i+1 < k) j++;
          //Reached window size
            else if(j-i+1 == k){
              //Calculations decision point
                maxsum = Integer.max(csum, maxsum);
              //Slide
                csum = csum - arr.get(i);
                i++;
                j++;
            }
        }
        return maxsum;
        
    }
}
