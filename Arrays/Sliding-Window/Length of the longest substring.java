class Solution{
    int longestUniqueSubsttr(String str){
        Queue<Character> q = new LinkedList();
        int i=0,j=0,maxlen=0;
        while(j<str.length()){
            //System.out.println(q);
            if(!q.contains(str.charAt(j))){
              q.add(str.charAt(j));
              maxlen = Integer.max(maxlen, q.size());
              j++;
             continue;
            }
            while(q.contains(str.charAt(j))){
                q.poll();
                i++;
            }
        }
        return maxlen;
}
}
