/*
Approach : O(n)
HASHMAP/HASHSET == Unique
k sized Windows
Remove earlier, update map, add current
Do the first window separately
*/
class Solution
{
    ArrayList<Integer> countDistinct(int a[], int n, int k)
    {
        // code here val,idx
        ArrayList<Integer> l = new ArrayList();
       HashMap<Integer,Integer> map = new HashMap();
       for(int i=0;i<k;i++){
           map.put(a[i],map.getOrDefault(a[i],0)+1);
       }
       l.add(map.size());
       for(int i=k;i<a.length;i++){
           if(map.get(a[i-k]) == 1){
               map.remove(a[i-k]);
           }
           else{
               map.put(a[i-k],map.get(a[i-k])-1);
           }
           map.put(a[i],map.getOrDefault(a[i],0)+1);
           l.add(map.size());
       }
       return l;
    }
}
