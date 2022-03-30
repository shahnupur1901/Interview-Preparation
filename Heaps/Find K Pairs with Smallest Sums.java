class Node{
      static ArrayList<String> visited = new ArrayList();
    int idx1, idx2, sum;
    Node(int i1, int i2, int sum){
        idx1 = i1;
        idx2 = i2;
        this.sum = sum;
        visited.add(this.nodeToString());
    }
    
   
    String nodeToString(){
        return String.valueOf(idx1)+" "+String.valueOf(idx2);
    }

}

class Solution {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue(new Comparator<Node>(){
            @Override
            public int compare(Node x, Node y){
                return x.sum > y.sum ? 1 : -1;
            }
        });
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        minHeap.add(new Node(0, 0, nums1[0]+nums2[0]));
        int currentK = 0;
        while(currentK!=k && minHeap.size()!=0){
            Node x = minHeap.poll();
            ArrayList<Integer> pair = new ArrayList();
            pair.add(nums1[x.idx1]);
            pair.add(nums2[x.idx2]);
            if(x.idx1+1 < nums1.length && !Node.visited.contains(String.valueOf(x.idx1+1)+" "+String.valueOf(x.idx2))){
                minHeap.add(new Node(x.idx1+1, x.idx2,nums1[x.idx1+1]+nums2[x.idx2] ));
            }
            if(x.idx2+1 < nums2.length && !Node.visited.contains(String.valueOf(x.idx1)+" "+String.valueOf(x.idx2+1))){
                minHeap.add(new Node(x.idx1, x.idx2+1,nums1[x.idx1]+nums2[x.idx2+1] ));
            }
            currentK++;
            answer.add(pair);
        }
        return answer;
    }
}
