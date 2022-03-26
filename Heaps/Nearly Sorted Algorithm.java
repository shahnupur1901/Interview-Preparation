/*
Sort a nearly sorted array 
Given an array of n elements, where each element is at most k (right/left) away from its target position. The task is to print array in sorted form.
- Keep 2 pointers - i & j
i : points to element in array which is to be changed.
j : points to element to be added in heap.

while j<n : add element to heap. When heap size > k : poll the min element from the top and place it at ith position and increase i
while i<n : pop remaining elements and fill the array
*/

	  public static void required(int a[], int n, int k) {
        // Your code goes here
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        int i = 0;
        int j = 0;
        while(j<n){
            //Decision time : 
            minHeap.add(a[j]);
            j++;
            if(minHeap.size() == k+1){
                a[i] = minHeap.poll();
                i++;
            }
        }
        while(i<n){
            a[i] = minHeap.poll();
            i++;
        }
        for(int x=0; x<n; x++){
            System.out.print(a[x]+" ");
        }
        
        
    }
}
