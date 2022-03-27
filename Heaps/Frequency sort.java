Given an array A[] of integers, sort the array according to frequency of elements.
  That is elements that have higher frequency come first. 
  If frequencies of two elements are same, then smaller number comes first.

static void sort(int arr[], int n){
	    for(int i=0; i<n; i++){
	        System.out.println(arr[i]);
	        map.put(arr[i], map.getOrDefault(arr[i],0)+1);
	    }
	    PriorityQueue<Integer> minHeap = new PriorityQueue(new Comparator<Integer>(){
	        @Override
	        public int compare(Integer x, Integer y){
	            if(map.get(x) == map.get(y)) return x>y ? -1 : 1;
	            return map.get(x) > map.get(y) ? -1 : 1;
	        }
	    });
	    for(Map.Entry mapElement : map.entrySet()){
	        int num = (int) mapElement.getKey();
	        int frequency = (int) mapElement.getValue();
	        minHeap.add(num);
	    }
	    int idx = 0;
	    while(!minHeap.isEmpty()){
	    int element = minHeap.poll();
	    for(int i=idx;i<idx+map.get(element);i++){
	        arr[i] = element;
	    }
	    return arr;
