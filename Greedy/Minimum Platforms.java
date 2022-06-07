class Node{
    int time;
    char task;
    Node(int a, char b){
        time = a;
        task = b;
    }
}
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        PriorityQueue<Node> minHeap = new PriorityQueue(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.time < n2.time) return -1;
                if(n1.time == n2.time){
                    if(n1.task == 'a') return -1;
                    else return 1;
                }
                return 1;
            }
        });
        
        for(int i=0;i<n;i++){
            minHeap.add(new Node(arr[i], 'a'));
            minHeap.add(new Node(dep[i], 'd'));
        }
        
        int count = 0;
        int max = count;
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            // System.out.println(node.time);
            if(node.task == 'a') count++;
            else count--;
            max = Math.max(max, count);
        }
        return max;
        
        
    }
    
}

