/*
Given an array A of positive integers. Your task is to find the leaders in the array. 
An element of array is leader if it is greater than or equal to all the elements to its right side. 
The rightmost element is always a leader. 
Traverse from right to left. keep maxright value in a variable and always compare current element with it
*/

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int maxright = arr[n-1];
        ArrayList<Integer> ans = new ArrayList();
        for(int i=n-1;i>=0;i--){
            if(arr[i] >= maxright){
                ans.add(arr[i]);
                maxright = arr[i];
            }
            
        }
        Collections.reverse(ans);
        return ans;
    }
}

