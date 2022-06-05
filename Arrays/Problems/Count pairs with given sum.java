
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
       HashMap<Integer,Integer> map = new HashMap();
       int count = 0;
       for(int i=0;i<n;i++){
           int diff = k-arr[i];

           if(map.keySet().contains(diff)){
               count = count + map.get(diff);
               //System.out.println("c : "+count);
           }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
           // System.out.println(map);
       }
       return count;
    }
}
