/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). 
Find all possible paths that the rat can take to reach from source to destination. 
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). 
Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.
*/
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> arr = new ArrayList();
      //If the bottom right element is inaccessible, ie, 0 return -1
        if(m[n-1][n-1]==0) {
            arr.add("-1");
            return arr;
        }
        arr.addAll(find(m,0,0,"", new boolean[n][n]));
        Collections.sort(arr);
        return arr;
    }
    public static ArrayList<String> find(int[][] m, int r, int c, String path, boolean visited[][]){
        int n = m.length;
          //Inaccessible or visited node - return empty arrayList
          if(m[r][c]==0 || visited[r][c]) {
            ArrayList<String> x = new ArrayList();
            return x;
        }
       //Last required node reached and accessible, return arrayList with its element
        if(r==n-1 && c==n-1 && m[r][c]==1) {
            ArrayList<String> a = new ArrayList();
            a.add(path);
            return a;
            }
        //Making this node visited
        visited[r][c] = true;
        //Answer arrayList
        ArrayList<String> b = new ArrayList();
        //Making sure it isn;t the last row, then calling the node below it.
        if(r!=n-1) b.addAll(find(m,r+1,c,path+"D", visited));
      //
        if(c!=n-1) b.addAll(find(m,r,c+1,path+"R", visited));
      //
        if(r!=0) b.addAll(find(m, r-1, c, path + "U", visited));
      //
        if(c!=0) b.addAll(find(m, r, c-1, path + "L", visited));
      
      //Backtracking (undoing changes)
        visited[r][c] = false;
      //returning arraylist
        return b;
    }
  // Example path matrix :
  1 0 0
  2 0 0
  3 4 5
  //To print the matrix, include another parameter called step and path matrix. Step updates the path (+1 implies another call and the next step), 
  //and during backtracking the path is turned to 0 again
  static ArrayList<String> printRatInMaze(String directions, int step, int m, int n, int r, int c, boolean visited[][], int[][] maze, int[][] path){
	  //Print the path matrix at last stop  
    if(r==m-1 && c==n-1 && maze[r][c]==1){
	        step = step + 1;
	        path[r][c] = step; 
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                System.out.print(path[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println(directions);
	        ArrayList<String> a = new ArrayList();
	        a.add(directions);
	        return a;
	    }
	    else if( r>=m || c>=n || maze[r][c]==0 || visited[r][c]){
	        ArrayList<String> b = new ArrayList();
	        return b;
	    }
	    ArrayList<String> arr = new ArrayList();
	    visited[r][c] = true;
    //Increment step, and path[][] = step
	    step = step + 1;
	    path[r][c] = step; 
	    if(r!=m-1){
	        arr.addAll(printRatInMaze(directions + "D", step, m, n, r + 1, c, visited, maze, path));
	    }
	     if(c!=n-1){
	        arr.addAll(printRatInMaze(directions + "R", step, m, n, r, c+1, visited, maze, path));
	    }
	     if(r!=0){
	        arr.addAll(printRatInMaze(directions + "U", step, m, n, r - 1, c, visited, maze, path));
	    }
	     if(c!=0){
	        arr.addAll(printRatInMaze(directions + "L", step, m, n, r, c-1, visited, maze, path));
	    }
    //backtracking
	    path[r][c] = 0;
	    visited[r][c] = false;
	    return arr;
	}
	
}
