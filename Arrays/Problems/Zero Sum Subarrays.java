class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long, ArrayList<Integer>> hmap = new HashMap();
        long cursum = 0, count = 0;
        for(int i=0;i<n;i++){
            cursum = cursum + arr[i];
            if(cursum == 0) count++;
            if(hmap.containsKey(cursum)) {
                count += hmap.get(cursum).size();
                hmap.get(cursum).add(i);
            }
            if(!hmap.containsKey(cursum)){
                ArrayList<Integer> l = new ArrayList();
                l.add(i);
                hmap.put(cursum, l);
            }
        }
        return count;
    }
}
