/*
Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of elements.
Note: All elements of this array should be part of exactly one partition.
Input: 
N = 5
a[] = {2,1,4,5,6}
K = 3
Output: 
1
Explanation: we can divide above array 
into 3 parts with equal sum as (2, 4), 
(1, 5), (6)
Idea : 
Parameters : n, k, subsetSum[] array of len k, ArrayList<Integer> subset[] -> array of k with arraylist elements to store subsets, idx index of ele in given array, 
arr given array, requiredSumOfEachSubset = given array sum / k;
Algo :
-if (k==0(number of remaining empty subsets)  || idx==n) && subsetSum elements == required sum -> subset exists, else return false;
- loop through subset[].
For all non-empty subsets, add idx element in subset, update subsetsum array, call func again,(backtracking) update subset, remove element
if true return true
For the first empty subset :add idx element in subset, update subsetsum array, call func again, update subset, remove element & break
if true return true

return false

*/
class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	//k buckets
	int sum = 0;
	for(int i:a){
	    sum = sum + i;
	}
	if(k==1) return true;
	if(k > n || sum%k != 0) return false;
	ArrayList<Integer> subset[] = new ArrayList[k];
	for(int i=0;i<k;i++){
	    subset[i] = new ArrayList<Integer>();
	}
	int[] subsetSum = new int[k];
	int requiredSum = sum/k;
	return creatingSubsets(subset, 0,subsetSum, a, k, requiredSum, n, k);
    }
    
    boolean creatingSubsets(ArrayList<Integer> subset[], int idx, int[] subsetSum, int[] a, int k, int requiredSum, int n, int numEmptySubsets){
        
        if(idx == n){
            if(numEmptySubsets == 0){
            for(int i=0;i<k;i++){
                int s = 0;
                for(int j : subset[i]){
                    s=s+j;
                }
                if(s!=requiredSum) return false;
            }
            return true;
         }
         else{
             return false;
         }
        }
        boolean try1 = false,try2=false;
        //Add element to x to first non-empty subset
        for(int i=0;i<k;i++){
            if(subset[i].size()!=0){
                subset[i].add(a[idx]);
                subsetSum[i] = subsetSum[i] + a[idx];
                try1 = creatingSubsets(subset,idx+1, subsetSum, a, k, requiredSum, n, numEmptySubsets);
                subset[i].remove(subset[i].indexOf(a[idx]));
                subsetSum[i] = subsetSum[i] - a[idx];
                if(try1) return true;
            }
            else{
                subset[i].add(a[idx]);
                subsetSum[i] = a[idx];
                try2 = creatingSubsets(subset,idx+1, subsetSum, a, k, requiredSum, n, numEmptySubsets-1);
                subset[i].remove(subset[i].indexOf(a[idx]));
                subsetSum[i] = subsetSum[i] - a[idx];
                if(try2) return true;
                break;
            }
        }
        //Add element to first empty subset
        return false;
    }
    
    
}



  
