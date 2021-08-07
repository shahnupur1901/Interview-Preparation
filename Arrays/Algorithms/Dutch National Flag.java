/*
Sort array with 0,1,2 only
Solution 1 : Brute force sorting : O(nlogn)
Solution 2 : Counting sort : O(n+k)/O(n+2)
Solution 3 : Dutch national flag : O(n)
Initial : low = mid = 0, high = arr.length - 1
while : mid<=high
Final :

0000000000000  1111111111111 2222
               |           | |
               low      high mid
     
*/
class Solution {
    public void sortDNF(int[] arr) {
        int low = 0,mid = 0;
        int high = arr.length - 1;
        while(mid<=high){
            if(arr[mid]==0){
                arr[mid] = arr[low];
                arr[low] = 0;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                arr[mid] = arr[high];
                arr[high]  = 2;
                high--;
            }

        }
    
    }
}
