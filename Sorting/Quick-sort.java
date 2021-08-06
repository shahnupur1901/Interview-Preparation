/*
	 * Quick sort : 
	 * 
	 * Not a stable sort 
	 * 
	 * Worst Time complexity :O(n^2) --> Most unbalanced partitions (kind of sorted already)
	 * Average Time complexity :O(nlog(n))
	 * Best Time complexity :O(nlog(n)) --> Even partitions
	 * 
	 * Recurrence relation :
	 * |   i   | sorted pivot | n - 1 - i |
	 * T(N) = T(i) + T(N-1-i) + cN 
	 * cN : time to build partition
	 * T(i) : quicksort for earlier i
	 * 
	 * Space Complexity : Recursion stack dependent
	 * Average Case : O(log n)
	 * Worst Case : O(n)
	 */
	void quicksort(int arr[],int lb,int ub) {
		if(lb<ub) {
			int idx = partition(arr,lb,ub);
			quicksort(arr,lb,idx-1);
			quicksort(arr,idx+1,ub);
			
		}
	}
	int partition(int arr[],int lb,int ub) {
		int pivot = arr[lb];
		int start = lb, end = ub;
		while(start<end) {
			while(start<=ub && arr[start]<=pivot) {
				start++;
			}
			while(end>=0 && arr[end] > pivot) {
				end--;
			}
			if(start<end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		arr[lb] = arr[end];
		arr[end] = pivot;
		return end;
	}
