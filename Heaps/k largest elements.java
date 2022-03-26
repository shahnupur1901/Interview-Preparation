/*
k largest elements
Given an array Arr of N positive integers, find K largest elements from the array.  The output elements should be printed in decreasing order.
*/

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k) minHeap.poll();
        }
        int[] answer = new int[minHeap.size()];
        int idx = 0;
        while(!minHeap.isEmpty()){
            answer[idx] = minHeap.poll();
            idx++;
        }
       Arrays.sort(answer);
       for(int i=0, j=answer.length-1; i<j; i++,j--){
           int temp = answer[i];
           answer[i] = answer[j];
           answer[j] = temp;
       }
        return answer;
        
        
    }
}
