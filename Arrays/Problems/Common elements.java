class Solution
{
    ArrayList<Integer> commonElements(int a1[], int a2[], int a3[], int n1, int n2, int n3) 
    {
        // code here 
        int i=0, j=0,k=0;
        ArrayList<Integer> ans = new ArrayList();
        while(i<n1 && j<n2 && k<n3){
            if(a1[i] == a2[j] && a2[j] == a3[k] && !ans.contains(a1[i])){
                ans.add(a1[i]);
            }
            int min = Integer.min(a1[i], a2[j]);
            min = Integer.min(min, a3[k]);
            if(min == a1[i]) {i++;}
            else if(min == a2[j]) {j++;}
            else {k++;}
            
        }
    
        return ans;
    }
    
}
