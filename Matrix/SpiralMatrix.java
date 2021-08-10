/*
VERY COOL!
4 pointers : 

      left___________________ right
  top |                      |
      |                      | 
      |                      |
      |                      |     
      |`                     |    
      |______________________|
      bottom
      first borders, then inner is a another matrix
      i = left;i<right;i++ --> top++
      i = top;i<bottom;i++;--> right--
      i = right-1;i<=left;i--> bottom--
      i = bottom-1;i<=top;i-- -->left++

*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;
        while(left<right && top<bottom){
            for(int i = left;i<right;i++){
                l.add(matrix[top][i]);
            }
            top++;
            for(int i = top;i<bottom;i++){
                l.add(matrix[i][right-1]);
            }
            right--;
            if(left>=right || top>=bottom) break;
            for(int i = right-1;i>=left;i--){
                l.add(matrix[bottom-1][i]);
            }
            
            bottom--;
            for(int i = bottom-1;i>=top;i--){
                l.add(matrix[i][left]);
            }
            left++;
        }
        return l;
    }
}
