import java.util.*;
public class Main
{
    int findShortestPathLength(int mat[][], int sx, int sy, int dx, int dy){
        Queue<Integer> rq = new LinkedList();
         Queue<Integer> cq = new LinkedList();
         boolean visited[][] = new boolean[mat.length][mat[0].length];
         rq.add(sx);
         cq.add(sy);
         visited[sx][sy] = true;
         int currentlayercount = 1;
         int nextlayercount = 0;
         int movecount = 0;
         while(!rq.isEmpty() && !cq.isEmpty()){
             int x = rq.poll();
             int y = cq.poll();
             if(x==dx && y==dy){
                 break;
             }
             visited[x][y] = true;
             nextlayercount = exploreNeighbours(mat, rq, cq, x, y, visited, nextlayercount);
             currentlayercount--;
             if(currentlayercount == 0){
                 currentlayercount = nextlayercount;
                 nextlayercount = 0;
                 movecount++;
             }
             
         }
         return movecount;
         
    }
    
    int exploreNeighbours(int mat[][], Queue<Integer> rq, Queue<Integer> cq, int x, int y, boolean visited[][], int nextlayercount){
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1, 0, 0};
        for(int i = 0;i<4;i++){
            int rr = x + dr[i];
            int cc = y + dc[i];
            if(rr < 0 || cc < 0) continue;
            if(rr>=mat.length || cc >=mat[0].length) continue;
            if(visited[rr][cc]) continue;
            if(mat[rr][cc] == 0 ) continue;
            rq.add(rr);
            cq.add(cc);
            visited[rr][cc] = true;
            nextlayercount++;
        }
         return nextlayercount;
    }
	public static void main(String[] args) {
	     {
        int mat[][] =
        {
            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
            { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
            { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
            { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
        };
        Main m = new Main();
        int min_dist = m.findShortestPathLength(mat, 0, 0, 7, 5);
 
        if (min_dist != -1) {
            System.out.println("The shortest path from source to destination " +
                    "has length " + min_dist);
        } else {
            System.out.println("Destination cannot be reached from source");
        }
    }
	}
}
