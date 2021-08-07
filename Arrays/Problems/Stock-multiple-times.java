/*
If tomorrow's stock price is > today's, buy. The difference is adjusted, thus the solution is very simple!

O(n)

*/

int multiple(int[] arr) {
		int profit = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i] - arr[i-1] > 0) {
				profit = profit + arr[i] - arr[i-1];
			}
		}
		return profit;
	}
