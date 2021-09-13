/*
Approach : 
1 loop to go through all vertices. 
Initialize a count variable which will color specific clouds with same numbers,

dfs for each cloud
*/

class TestClass {
    void dfs(ArrayList<ArrayList<Integer>> l, int v, boolean[] visited, int coloredv[]){
    int count = 0;
    for(int i=0;i<l.size();i++){
        if(!visited[i]){
            colorConnected(i,l,visited,count,coloredv);
            count++;
        }
    }
    System.out.println(count);

}
void colorConnected(int v, ArrayList<ArrayList<Integer>> l, boolean[] visited, int count,int coloredv[]){
    visited[v] = true;
    coloredv[v] = count;
     for(int vertex : l.get(v)){
        if(!visited[vertex]){
            colorConnected(vertex, l, visited, count, coloredv);
        }
    }
}
    public static void main(String args[] ) throws Exception {
       ArrayList<ArrayList<Integer>> l = new ArrayList();
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       int e = s.nextInt();
       for(int i=0;i<n;i++){
           l.add(new ArrayList<Integer>());
       }
       for(int i=0;i<e;i++){
           int lb = s.nextInt();
           int ub = s.nextInt();
           l.get(lb).add(ub);
           l.get(ub).add(lb);
       }
       int[] coloredv = new int[n];
       boolean[] visited = new boolean[n];
        TestClass c = new TestClass();
        c.dfs(l,0,visited,coloredv);
    }
}
