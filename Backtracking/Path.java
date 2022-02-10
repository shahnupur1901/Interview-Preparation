/*
- - - - - -
- - - - - - 
- - - - - -

after processing row 1,
- - - - - - 
- - - - - -
then col
- - - - -
- - - - -
*/

static void printPaths(String path, int m, int n){
  // 1 node (answer) remaining
	    if(m==1 && n==1){
	        System.out.println(path);
	        return;
	    }
	    if(m!=1) printPaths(path+"D", m-1, n);
	    if(n!=1) printPaths(path+"R", m, n-1);
	}
	static ArrayList<String> listPaths(String path, int m, int n){
	   
	    if(m==1 && n==1){
	        ArrayList<String> a = new ArrayList(); a.add(path);
	        return a;
	    }
	    ArrayList<String> b = new ArrayList();
	    if(m!=1) b.addAll(listPaths(path+"D", m-1, n));
	    if(n!=1) b.addAll(listPaths(path+"R", m, n-1));
	    return b;
	}
	static int includingDiagonalPaths(int m, int n){
	    if(m==1 && n==1) return 1;
	    else if(m==1 || n==1){
	        return 1;
	    }
	    return includingDiagonalPaths(m-1, n)+ includingDiagonalPaths(m, n-1)+includingDiagonalPaths(m-1, n-1);
	}
	static ArrayList<String> listWithDiagonals(String path, int m, int n){
	    if(m==1 && n==1){
	        ArrayList<String> a = new ArrayList();
	        a.add(path);
	        return a;
	    }
	    ArrayList<String> b = new ArrayList();
	    if(m!=1) b.addAll(listWithDiagonals(path+"D", m-1, n));
	    if(n!=1) b.addAll(listWithDiagonals(path + "R", m, n-1));
	    if(m!=1 && n!=1) b.addAll(listWithDiagonals(path + "V", m-1, n-1));
	    return b;
	}
	
	
	 static int shortestPath(int step, int m, int n, int r, int c, boolean visited[][], int[][] maze){
	    if(r==m-1 && c==n-1 && maze[r][c]==1){
	      return step+1;
	    }
	    else if( r>=m || c>=n || maze[r][c]==0 || visited[r][c]){
	        return Integer.MAX_VALUE;
	    }
	    visited[r][c] = true;
        int s = Integer.MAX_VALUE;
	    if(r!=m-1){
	        s = Integer.min(s, (shortestPath(step + 1, m, n, r + 1, c, visited, maze)));
	    }
	     if(c!=n-1){
	        s = Integer.min(s, (shortestPath(step + 1, m, n, r, c+1, visited, maze)));
	    }
	     if(r!=0){
	        s = Integer.min(s, (shortestPath(step + 1, m, n, r - 1, c, visited, maze)));
	    }
	     if(c!=0){
	        s = Integer.min(s, (shortestPath(step + 1, m, n, r, c-1, visited, maze)));
	    }
	    visited[r][c] = false;
	    return s;
	}

    //System.out.println(shortestPath(0, 3, 3, 0, 0, new boolean[3][3], maze));
		//printPaths("",3,3);
		//System.out.println(listPaths("", 3,3));
		//System.out.println(includingDiagonalPaths(3,3));
		//System.out.println(listWithDiagonals("", 3,3));
	
