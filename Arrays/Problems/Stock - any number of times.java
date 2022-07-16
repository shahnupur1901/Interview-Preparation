class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int arr[], int n) {
        // code here
        int start = 0, end = 0;
        ArrayList<ArrayList<Integer>> answer = new ArrayList();
        for(int i=1;i<n;i++){
            if(arr[i-1] < arr[i]){
                end = i;
            }
            else{
                if(start!=end){
             ArrayList<Integer> ans = new ArrayList();
             ans.add(start);
             ans.add(end);
             answer.add(ans);
            }
            start = i;
            end = i;
            }
        }
         if(start!=end){
             ArrayList<Integer> ans = new ArrayList();
             ans.add(start);
             ans.add(end);
             answer.add(ans);
            }
        return answer;
    }
}
