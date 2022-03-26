class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue(new Comparator<Integer>(){
          @Override
          public int compare(Integer x, Integer y){
              if(map.get(x) == map.get(y)){
                  return x > y ? 1 : -1;
              }
              return map.get(x) > map.get(y) ? 1 : -1;
          }
        });
        for(Map.Entry mapElement : map.entrySet()){
            int num = (int) mapElement.getKey();
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int answer[] = new int[minHeap.size()];
        for(int i=k-1;i>=0;i--){
            answer[i] = minHeap.poll();
        }
        return answer;
    }
}
