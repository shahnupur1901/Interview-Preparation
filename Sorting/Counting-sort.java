/*
 * Counting sort for non-negative numbers
 *
 * Worst Time complexity :O(n+k)
 * Average Time complexity :O(n+k)
 * Best Time complexity :O(n+k)
 
 * Space Complexity : O(n+k)
 *
 * n = total number of elements
 * k = maximum number in the array.
 * count arr size : k+1
 * Necessity : k must be feasible, k = O(n),k can be 2n, 3n, not n^2
 * Modification needed for negative numbers using normalization (adding most negative number to all the numbers)
 * If no good range, use radix sort.
 */
public class CountingSort {
	void countingsort(int[] arr) {
		int n = arr.length;
		int k = 0;
		int sorted[] = new int[n];
		for(int i = 0;i<n;i++) {//finding the maximum range
			if(k < arr[i])
				k = arr[i];
		}
		int count[] = new int[k+1];
		for(int i = 0;i<n;i++) {//updating the count array which maintains the frequency
			count[arr[i]] ++;
		}
		for(int i=1;i<=k;i++) {//Calculating the indices
			count[i] = count[i] + count[i-1];
		}
		for(int i=n-1;i>=0;i--) {
			count[arr[i]] --;//subtract 1 to get required the index
			sorted[count[arr[i]]] = arr[i];//update the sorted array
		}
		for(int i = 0;i<n;i++) {
			arr[i] = sorted[i];//update arr
			System.out.println(arr[i]);
		}
		
	}
	public static void main(String args[]) {
		int arr[] = {5,2,7,1,9,3};
		CountingSort cs = new CountingSort();
		cs.countingsort(arr);
		
	}
}
