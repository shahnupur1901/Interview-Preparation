	/*
  Given integers N and K, the task is to place K knights on an N*N chessboard such that they don’t attack each other.
  */
//All checks
static boolean isKnightSafe(int row, int col, int board[][]){
	    int n = board.length;
	    if(row-2<n && col+1<n && row-2>=0 && col+1>=0 && board[row-2][col+1]==1) return false;
	    if(row-2<n && col-1<n && row-2>=0 && col-1>=0 && board[row-2][col-1]==1) return false;
	    if(row-1<n && col-2<n && row-1>=0 && col-2>=0 && board[row-1][col-2]==1) return false;
	    if(row-1<n && col+2<n && row-1>=0 && col+2>=0 && board[row-1][col+2]==1) return false;
	    return true;
	}
//Traversing each element one row after another
	static void placekKnights(int[][] board, int i, int j, int n, int numKnightsToBePlaced){
    //All nights places
	    if(numKnightsToBePlaced == 0){
	         for(int x=0;x<n;x++){
	            for(int y=0;y<n;y++){
	                System.out.print(board[x][y]);
	            }
	            System.out.println();
	        }
	         System.out.println();
	        return;
	    }
    //After the Last element
	    if(i==n-1 && j==n) return;
    //The last column element
	    if(j==n){
	        placekKnights(board, i+1, 0, n, numKnightsToBePlaced);
	        return;
	    }
    //check if knight is safe and place
	    if(isKnightSafe(i, j, board)){
	    board[i][j] = 1;
	    placekKnights(board, i, j+1, n, numKnightsToBePlaced-1);
	    board[i][j] = 0;
	    }
    //don't place and go ahead
	    placekKnights(board, i, j+1, n, numKnightsToBePlaced);
	    return;
	    
	}
