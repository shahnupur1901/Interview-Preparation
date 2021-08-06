/*
	 * Selection sort : 
	 * Inefficient for large lists
	 * 
	 * Not a Stable sort
	 * Worst case time complexity : O(n^2)
	 * Average case time complexity : O(n^2)
	 * Best case time complexity : O(n^2)
	 * 		         ---->
	 *  | sorted    | unsorted |
	 *  
	 *  Space complexity : O(1)
	 */
	void selectionsort(int arr[]) {
		int min = 0;
		for(int i=0;i<arr.length;i++) {
			min = i;//remember to initialize
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
