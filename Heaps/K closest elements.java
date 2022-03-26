/*
Priority Queue has an object with key - difference between x and arr[i], and arr[i]
Now perform k min elements with difference.
Given a sorted array, arr[] of N integers, and a value X. Find the K closest elements to X in arr[].
Keep the following points in mind:

If X is present in the array, then it need not be considered.
If there are two elements with the same difference with X, the greater element is given priority.
If sufficient elements are not present on the right side then take elements from left and vice versa.
 
*/

class Node{
    int key, value;
    Node(int k, int v){
        key = k;
        value = v;
    }
}
class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
      PriorityQueue<Node> maxHeap = new PriorityQueue(new Comparator<Node>() {

        @Override
      public int compare(Node arg0, Node arg1) {
        // TODO Auto-generated method stub
        if(arg0.key == arg1.key){
            return arg0.value > arg1.value ? 1:-1;
        }
        return arg0.key>arg1.key?-1:1;
        }
    });
        
        for(int i=0; i<n; i++){
            if(arr[i]==x) continue;
            int key = Math.abs(arr[i] - x);
            int val = arr[i];
            maxHeap.add(new Node(key, val));
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int answer[] = new int[maxHeap.size()];
        for(int i=maxHeap.size()-1;i<k && maxHeap.size()!=0;i--){
           answer[i] = maxHeap.poll().value;
        }
        return answer;
