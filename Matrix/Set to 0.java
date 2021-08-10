/*
O(m+n) space complexity by taking two arrays of row and column size
O(mn) time complexity
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int x[] = new int[matrix[0].length];
        System.out.println(x.length);
        int y[] = new int[matrix.length];
         System.out.println(y.length);
        Arrays.fill(x,-1);
        Arrays.fill(y,-1);
        for(int i=0;i<y.length;i++){
            for(int j=0;j<x.length;j++){
                if(matrix[i][j]==0){
                    x[j] = 0;
                    y[i] = 0;
                }
            }
        }
        for(int i=0;i<y.length;i++){
            if(y[i]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int i=0;i<x.length;i++){
            if(x[i]==0){
                for(int j=0;j<y.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        
        
    }
}
