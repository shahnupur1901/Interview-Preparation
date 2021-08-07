/*
 * The cost of a stock on each day is given in an array, 
 * find the max profit that you can make by buying and selling in those days. 
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, 
 * the maximum profit can earned by buying on day 0, selling on day 3.
 *  Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, 
 *  then profit cannot be earned at all.
 */
public class Stock {
  /*
  Kadane's algorithm : O(n)
  1. Create a difference array between consecutive elements.
  2. Find the subarray with maximum sum.
  */
	int kadane(int[] arr) {
		int diff[] = new int[arr.length-1];
		for(int i=1;i<arr.length;i++) {
			diff[i-1] = arr[i] - arr[i-1];
		}
		int maxprofit = 0;
		//max sum subarray
		int maxsum = Integer.MIN_VALUE, cursum = 0;
		for(int i = 0;i<diff.length;i++) {
			cursum = cursum + diff[i];
			if(maxsum < cursum) {
				maxsum = cursum;
			}
			if(cursum < 0) {
				cursum = 0;
			}
		}
		System.out.println(maxsum);
		return maxsum;
		
	}
	/*
  Normal method : O(n)
  1. Keep a profit variable
  2. Keep a min variable to store the day with minimum stock price so far.
  3. 2 conditions : 
      a) update minimum
      b) update profit
  */
	int difference(int[] arr) {
		int profit = 0;
		int min = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
			if(profit<arr[i]-min) {
				profit = arr[i] - min;
			}
		}
		return profit;
	}
	public static void main(String args[]) {
		int arr[] = {7,1,5,3,6,4};
		Stock s = new Stock();
		s.kadane(arr);
		System.out.println(s.difference(arr));
		
	}
}
