/*
Best Approach : O(n)
XOR :
1. XOR of number with itself : 0
2. XOR of number with 0 : number itself

n^n = 0
n^0 = n
So xor all numbers in the array and the resultant is the missing 
xor is commutative and associative
{7, 3, 5, 4, 5, 3, 4}
7^3^5^4^5^3^4
=7^(3^3)^(5^5)^(4^4)
=7^0^0^0
=7


Approach 2 : 
HashSet
Add element to set.
if size of set does not increase -> its duplicate doesn't exist
*/
int elementNotPresent(int arr[]) {
		int res = 0;
		for(int i=0;i<arr.length;i++) {
			res = res ^ arr[i];
		}
		return res;
	
	}
