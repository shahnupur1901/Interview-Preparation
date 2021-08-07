/*
1. Keep 2 variables 
    start : start of window
    maxlength : maxlength of subarray window so far
2. Maintain a hashmap containing element as key, index as value.
3. It will only contain unique values.
4. Loop till array end 
  if array contains that element :
  -- start will be max of start and map.get(arr[i])+1
  will be start if duplicate isn't in sliding window
  will be map.get(arr[i])+1 if in sliding window
  
  if not, add in map
  
  check maxlen = max of maxlen, i-start+1
*/

	int longestSubarray(int arr[]) {
		HashMap<Integer,Integer> map = new HashMap();
		int maxlen = 0,start = 0;
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])){
				map.put(arr[i],i);
			}
			else {
				start = Integer.max(start,map.get(arr[i])+1);
				map.put(arr[i], i);
			}
			maxlen = Integer.max(maxlen,i-start+1);
			
		}
		return maxlen;
	}

