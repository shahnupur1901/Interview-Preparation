/*
Logic : 
Maintain a minimum and maximum so far.
j & i are the start of subarray and current indices respectively
whenever max - min == i - j : contiguous elements in window from i to j including i,j
Maintain a hashset for subarray. If duplicate element found, break the j loop as duplicates shouldn't be in this array
O(n^2) Time complexity

*/

	int longestSubarrayWithContiguous(int arr[]) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int maxlength = 0;
		for(int i=0;i<arr.length-1;i++) {
			min = arr[i];
			max = arr[i];
			HashSet<Integer> set = new HashSet();
			set.add(arr[i]);
			for(int j=i+1;j<arr.length;j++) {
				if(set.contains(arr[j]))
					break;
				min = Integer.min(min,arr[j]);
				max = Integer.max(max,arr[j]);
				if(max-min == j-i) {
					maxlength = Integer.max(maxlength,j-i+1);
				}
			}
		}
		return maxlength;
		
	}
