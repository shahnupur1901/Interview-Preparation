class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]> (){
            public int compare(int[] i1, int[] i2){
                if(i1[0] >= i2[0]) return 1;
                else return -1;
            }
        });
        ArrayList<int[]> answer = new ArrayList();
        for(int i=0;i<intervals.length;i++){
            int[] interval = {intervals[i][0], intervals[i][1]};
            answer.add(interval);
        }
        for(int i=0;i<answer.size()-1;i++){
          System.out.println(answer.get(i)[0]+" "+answer.get(i)[1]);
            if(answer.get(i)[1] >= answer.get(i+1)[0]){
                int end = Integer.max(answer.get(i+1)[1],answer.get(i)[1]);
                int[] ans = {answer.get(i)[0], end};
                answer.set(i,ans);
                answer.remove(i+1);
                i--;
            }
            // System.out.println(answer.get(i)[0]+" "+answer.get(i)[1]);
            
        }
        int[][] a = new int[answer.size()][2];
        for(int i=0;i<answer.size();i++){
            a[i][0] = answer.get(i)[0];
             a[i][1] = answer.get(i)[1];
        }
        return a;
        
    }
}
