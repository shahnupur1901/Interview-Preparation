class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int board[][] = new int[n][n];
         ArrayList<ArrayList<Integer>> ans = nqueensProblem(n, board, 0);
         Collections.sort(ans, new Comparator<List<Integer>>() {
        public int compare(List<Integer> listOne, List<Integer> listTwo) {
        int oneSize = listOne.size();
        int twoSize = listTwo.size();
        for(int i = 0; i < oneSize; i++)
    {
        if(i == oneSize || i == twoSize)
            return oneSize - twoSize;

        int elementOne = listOne.get(i);
        int elementTwo = listTwo.get(i);
        if(elementOne == elementTwo)
            continue;
        return Integer.compare(elementOne, elementTwo);
        
    }
            return 0;
        }});
         return ans;
    }
    static ArrayList<ArrayList<Integer>> nqueensProblem(int n, int[][] board, int r){
        //Going through all rows and finding a suitable safe postion recursively
        if(r==n){
        //all above rows are successfully filled
            ArrayList<ArrayList<Integer>> a = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            for(int i=0;i<n;i++){//column
                for(int j=0;j<n;j++){//row
                    if(board[j][i]==1){
                        path.add(j+1);
                    }
                }
               
            }
            a.add(path);
            return a;
        }
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        for(int col=0;col<n;col++){
            if(isSafe(board, r, col,n)){
                board[r][col] = 1;
                b.addAll(nqueensProblem(n, board, r+1));
               // path.removeAll(Arrays.asList(r+1));
                board[r][col] = 0;
                
            }
        }
        return b;
    }
    static boolean isSafe(int[][] board, int r, int c, int n){
        //Checking the rows above this row r
        for(int i = 0;i<r;i++){
            if(board[i][c]==1){
                return false;
            }
        }
        int i=r-1, j=c-1;
        //Check left diagonal
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i = i - 1;
            j = j - 1;
        }
        //Check right diagonal
        i=r-1; j=c+1;
        while(i<n && j<n && i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
