
    static boolean knightTourProblem(int board[][], int row, int col, int numToVisit, int step, int[][] path){
        //System.out.println(row+" "+col+" "+numToVisit);
        if(numToVisit == 1){
            path[row][col] = step+1;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    System.out.print(path[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }
        if(row >= board.length || col >= board[0].length) return false;
        int xpos[] = {-1, -1, -2, -2, 1, 1, 2, 2};
        int ypos[] = {-2, 2, 1, -1, -2, 2, 1, -1};
            for(int i=0;i<8;i++){
                step = step + 1;
                path[row][col] = step;
                board[row][col] = 1;
                boolean x = false;
                if(row + xpos[i] >= 0 && row + xpos[i]<board.length && col + ypos[i]>=0 && col + ypos[i]<board[0].length
                && board[row + xpos[i]][col  + ypos[i] ]!=1){
                   x = knightTourProblem(board, row + xpos[i], col+ypos[i], numToVisit-1, step, path);
                }
               if(x) return true;
                step = step -1 ;
                path[row][col] = 0;
                board[row][col] = 0;
                
            }
        
        return false;
    }

	public static void main(String[] args) {
	    knightTourProblem(new int[5][8], 0, 0, 40, 0, new int[5][8]);
	}

1 8 11 20 3 6 13 18 
10 21 2 7 12 19 4 33 
27 24 9 36 5 32 17 14 
22 37 26 29 16 39 34 31 
25 28 23 38 35 30 15 40
