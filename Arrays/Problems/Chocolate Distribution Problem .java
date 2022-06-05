class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int k)
    {
        // your code here
        Collections.sort(a);
        long diff = Long.MAX_VALUE;
        int i = 0, j=0;
        while(j<n){
            if(j-i+1 < k) j++;
            else{
                diff = Long.min(a.get(j)-a.get(i), diff);
                i++;
                j++;
            }
        }
        return diff;
    }
}
