/*
Given an M x N matrix, with a few hurdles arbitrarily placed, calculate the length of the longest possible route possible from source to a destination within the matrix. 
We are allowed to move to only adjacent cells which are not hurdles. 
The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.
{1,1,1,1,1,1,1,1,1,1},
{1,1,0,1,1,0,1,1,0,1},
{1,1,1,1,1,1,1,1,1,1}
Ans : 24
Parameter list : i, j, di, dj, maxStep, visited[][], path[][], board[][]
*/
static int longestPathWithHurdles(int board[][], int step, int i, int j,int di, int dj, boolean visited[][]){
	    if(visited[i][j]) return 0;
	    int numRows = board.length;
	    int numCols = board[0].length;
  //distance so far
	    int originalPath = step;
  //reached destination?
	    if(i==di && j==dj) {
	        return step;
	    }
  //make the cell visited
	    visited[i][j] = true;
	    if(i!=numRows-1 && board[i+1][j]==1) {
	        step = Integer.max(step, longestPathWithHurdles(board, originalPath+1, i+1, j,di,dj, visited));
	    }
	    if(j!=numCols-1 && board[i][j+1]==1) {
	        step = Integer.max(step, longestPathWithHurdles(board, originalPath+1, i, j+1,di,dj, visited));
	    }
	    if(i!=0 && board[i-1][j]==1) {
	        step = Integer.max(step, longestPathWithHurdles(board, originalPath+1, i-1, j,di,dj, visited));
	    }
	    if(j!=0 && board[i][j-1]==1) {
	        step = Integer.max(step, longestPathWithHurdles(board, originalPath+1, i, j-1,di,dj, visited));
	    }
  //backtracking
	    visited[i][j] = false;
	    return step;
	    
	}
