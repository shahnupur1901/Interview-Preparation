class Solution {
    public void solveSudoku(char[][] mat) {
    if(mat==null || mat.length!=9) return;
       solve(mat, 0,0);
    }
       boolean solve(char[][] mat, int row, int col){
        if(row == mat.length-1 && col==9) {
    
            
            return true;
        
        }
        if(col == mat[0].length){
            return solve(mat, row+1, 0);
        }
        if(mat[row][col]!='.'){
            return solve(mat, row, col+1);
           
        }
        for(int j=1;j<=9;j++){
            if(isPosNumSafe(mat, row, col, j)){
                mat[row][col] =  (char) (j+'0');
                if(solve(mat, row, col+1)) return true;
                mat[row][col] = '.';
            }
        }
        return false;
        }
    
    boolean isPosNumSafe(char[][] mat, int row, int col, int n){
        char c = (char) (n+'0');
        for(int i=0;i<9;i++){
            if(mat[row][i]==c) return false;
            if(mat[i][col]==c) return false;
        }
        int x = row/3;
        int y = col/3;
        x = x*3;y = y*3;
        for(int m=x;m<x+3;m++){
            for(int l=y;l<y+3;l++){
                if(mat[m][l]==c) return false;
            }
        }
        return true;
        
    }
    
}
