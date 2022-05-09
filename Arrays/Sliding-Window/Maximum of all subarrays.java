class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList <Integer> ans = new ArrayList();
        // In this dequeue, the maximum will always be at the front
        ArrayDeque<Integer> dq = new ArrayDeque(); // potential maximums stored here
        int i=0, j=0;
        while(j<n){
            // poll from the rear if the value in queue is less than element at j
            // Why?
            // with arr[j] in picture, these can never be the maximum in any upcoming window
            // there is a chance arr[j] can a max in the future 
            while(!dq.isEmpty() && dq.peekLast() < arr[j]){
                dq.pollLast();
            }
            //insert arr[j]
            dq.offerLast(arr[j]);
            if(j-i+1 < k) j++;
            else{
                // max element is the one at the top
                ans.add(dq.peekFirst());
                //slide
                // if maximum is at arr[i], you've got to remove it.
                // Now remember, this is the first entry in the current window
                // Every other element was added afterwards. If it were greater it would be at front itself
                // And if it were less, it would have already been polled.
                if(dq.peekFirst() == arr[i]) dq.pollFirst();
                i++;
                j++;
            }
        }
        return ans;
    }
}
