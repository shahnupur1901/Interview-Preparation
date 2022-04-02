class HeapNode{
    int frequency;
    char task;
    HeapNode(int f, char t){
        frequency = f;
        task = t;
    }
}
class QueueNode{
    int nextPermissibleTime;
    //char task;
    int frequency;
    QueueNode(int time, int f){
         nextPermissibleTime = time;
        //task = t;
        frequency = f;
    }
}
class Solution {/*
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue(new Comparator<HeapNode>(){
            @Override
            public int compare(HeapNode x, HeapNode y){
                return x.frequency > y.frequency ? -1 : 1;
            }
        });       
        Queue<QueueNode> q = new LinkedList();
        int count[] = new int[26];
        for(int x = 0;x<tasks.length;x++){
            count[tasks[x] - 'A']++;
        }
        for(int x = 0;x<26;x++){
            if(count[x]!=0){
                maxHeap.add(new HeapNode(count[x], (char) (x+'A')));
            }
        }
        int numTasks = 0;
        int time = 0;
        while(numTasks!=tasks.length){
            if(maxHeap.size()!=0){
                HeapNode node = maxHeap.poll();
                System.out.println(node.task);
                if(node.frequency-1 != 0){
                    QueueNode qn = new QueueNode(time+n, node.task,node.frequency-1);
                    q.add(qn);
                }
                numTasks++;
            }
            while(!q.isEmpty() && q.peek().nextPermissibleTime == time){
                QueueNode qn = q.poll();
                HeapNode hn = new HeapNode(qn.frequency, qn.task);
                maxHeap.add(hn);
            }
            time++;
        }
        return time;
    }
    */
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());       
        Queue<QueueNode> q = new LinkedList();
        HashMap<Character, Integer> map = new HashMap();
        for(int x = 0;x<tasks.length;x++){
         map.put(tasks[x], map.getOrDefault(tasks[x],0)+1);
        }
        for(Map.Entry mapElement : map.entrySet()){
            maxHeap.add((int)mapElement.getValue());
        }
        int numTasks = 0;
        int time = 0;
        while(numTasks!=tasks.length){
            if(maxHeap.size()!=0){
                int f = maxHeap.poll();
                if(f-1 != 0){
                    QueueNode qn = new QueueNode(time+n,f-1);
                    q.add(qn);
                }
                numTasks++;
            }
            while(!q.isEmpty() && q.peek().nextPermissibleTime == time){
                QueueNode qn = q.poll();
                maxHeap.add(qn.frequency);
            }
            time++;
        }
        return time;
        
        
    }
}
