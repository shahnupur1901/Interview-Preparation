
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        //rows for number of elements, here length
        //cols for current length like sum
        int t[][] = new int[price.length+1][n+1];
        int length[] = new int[price.length];
        for(int i=0;i<price.length;i++) length[i] = i+1;
        for(int i=0;i<price.length+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }
        
        for(int i=1;i<price.length+1;i++){
            for(int j=1;j<n+1;j++){
                if(length[i-1] <= j){
                    //important : t[i][j-1]
                    t[i][j] = Integer.max(t[i-1][j], price[i-1]+t[i][j-length[i-1]]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[length.length][n];
    }
}
