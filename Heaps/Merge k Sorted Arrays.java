class Node{
    int num, arrayidx, idx;
    Node(int n, int a, int i){
        num = n;
        arrayidx = a;
        idx = i;
    }
}


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        ArrayList<Integer> answer = new ArrayList();
      //Firstly, add all the first elements of the arrays in the heap.
        PriorityQueue<Node> minheap = new PriorityQueue(new Comparator<Node>(){
            @Override
            public int compare(Node x, Node y){
                return x.num < y.num ? -1 : 1;
            }
            
        });
        for(int i=0;i<k;i++){
            Node x = new Node(arr[i][0], i,0);
            minheap.add(x);
        }
      
        while(!minheap.isEmpty()){
            Node x = minheap.poll();
            answer.add(x.num);
          //Check if any element exists in the array of the polled element
            if(x.idx+1 < arr[x.arrayidx].length){
                minheap.add(new Node(arr[x.arrayidx][(x.idx)+1], x.arrayidx, (x.idx)+1));
            }
            else{
                continue;
            }
        }
        return answer;
    }
}
