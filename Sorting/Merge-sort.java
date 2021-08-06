/*
	 * Merge sort : 
	 * External sort
	 * Stable sort 
	 * 
	 * Worst Time complexity :O(nlog(n)) 
	 * Average Time complexity :O(nlog(n))
	 * Best Time complexity :O(nlog(n))
	 * 
	 * Recurrence relation :
	 * T(n) = 2T(n/2) + cn
	 * 
	 * Space Complexity : O(n)
	 */
	void mergesort(int arr[],int lb,int ub) {
		if(lb<ub) {
			int midpt = (lb + ub)/2;
			mergesort(arr,lb,midpt);
			mergesort(arr,midpt+1,ub);
			merge(arr,lb,midpt,ub);
			}
	}
	void merge(int arr[],int lb,int midpt,int ub) {
		int a[] = new int[arr.length];
		int i = lb, j = midpt+1;
		int k = lb;
		while(i<=midpt && j<=ub) {
			if(arr[i] <= arr[j]) {
				a[k] = arr[i];
				i++;
				k++;
			}
			else {
				a[k] = arr[j];
				k++;
				j++;
			}
		}
		if(i<=midpt) {
			while(i<=midpt) {
				a[k] = arr[i];
				k++;
				i++;
			}
		}
		else if(j<=ub) {
			while(j<=ub) {
				a[k] = arr[j];
				j++;
				k++;
			}
		}
		for(k=lb;k<=ub;k++) {//remember to copy!
			arr[k] = a[k];
		}
	}
