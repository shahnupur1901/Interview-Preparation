class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        //Choosing minHeap as we want to reduce cost
        PriorityQueue<Long> minHeap = new PriorityQueue();
        //First, adding all elements in heap
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
        }
        long totalCost = 0;
        //while heap contains > 2 elements : pop 2 and find cost and add again.
        //if size = 1, finally the ropes have all been connected.
        while(minHeap.size() >= 2){
            long ropeOne = minHeap.poll();
            long ropeTwo = minHeap.poll();
            long cost = ropeOne + ropeTwo;
            minHeap.add(cost);
    
            totalCost = totalCost + cost;
        }
        return totalCost;
    }
}
