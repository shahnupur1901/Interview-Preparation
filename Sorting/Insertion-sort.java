/*
	 * Insertion sort : 
	 * Stable sort
	 * Worst case time complexity : O(n^2)
	 * Average case time complexity : O(n^2)
	 * Best case time complexity : O(n)
	 * 
	 *  | sorted    | unsorted |
	 *  
	 *  Space complexity : O(1)
	 */
	void insertionsort(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
