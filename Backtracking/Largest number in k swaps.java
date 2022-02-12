/*
Given a number K and string str of digits denoting a positive integer,
build the largest number possible by performing swap operations on the digits of str at most K times.
Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4 

Parameter list : String max (so far), input char array, idx index, int k (numswaps remaining)
- if k==0 || i==arr.length return max
- for i=idx+1, i<arr.length;i++ 
  if arr[i] > arr[idx] 
  swap
  update max
  call function - max, arr, idx+!, k-1
  backtracking
  update max
  swap
  flag = 1
 
- if flag == 0 implying the element at idx is the largest ahead, simply call the function again with k = k

*/

class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            char arr[] = str.toCharArray();
            return maximum(arr, k, str, 0);
         }
          static String maximum(char arr[], int k, String ans, int i){
          if(k==0) return ans;
          if(i==arr.length) return ans;
          int current = Integer.parseInt(String.valueOf(arr[i]));
          int flag = 0;
          for(int idx=i+1; idx<arr.length ;idx++){
              if(Integer.parseInt(String.valueOf(arr[idx])) > current){
                  char temp = arr[i];
                  arr[i] = arr[idx];
                  arr[idx] = temp;
                  
                  String swapped = String.valueOf(arr);
                  java.math.BigInteger bi = new java.math.BigInteger(swapped);
                  java.math.BigInteger answer = new java.math.BigInteger(ans);
                  if(bi.compareTo(answer) > 0) {
                	  ans = bi.toString();
                  }
                  String call = maximum(arr, k-1, ans, i+1);
                  java.math.BigInteger callanswer = new java.math.BigInteger(call);
                  if(callanswer.compareTo(answer) > 0) ans = callanswer.toString();
                 
                  temp = arr[i];
                  arr[i] = arr[idx];
                  arr[idx] = temp;
                  flag = 1;
              }
         }
         if(flag == 0){
              java.math.BigInteger answer = new java.math.BigInteger(ans);
              String call = maximum(arr, k, ans, i+1);
             java.math.BigInteger callanswer = new java.math.BigInteger(call);
             if(callanswer.compareTo(answer) > 0) ans = callanswer.toString();
         }
         
         return ans;
    
        }
}

