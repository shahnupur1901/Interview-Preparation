class Solution {
    public void setZeroes(int[][] matrix) {
        // Mark elements to be zeroed as null.
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0){
                    markRow(i, matrix);
                    markCol(j, matrix);
                    System.out.println(String.format(" Main loop: %d, %d", i, j));
                }
                 
            }
        }
           for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == -1){
                    matrix[i][j] = 0;
                    System.out.println(String.format("Traversing: %d, %d = %d", i, j, matrix[i][j]));
                }
            }
        }
    }
    public void markRow(int i, int[][] matrix){
        for (int j = 0;j<matrix[i].length;j++ ){
            if (matrix[i][j] != 0){ 🤦‍♀️
            matrix[i][j] = -1;
            System.out.println(String.format("%d, %d", i, j));
            }
        }
    }
    
    public void markCol(int j, int[][] matrix){
        for (int i = 0;i<matrix.length;i++ ){
            if (matrix[i][j] != 0){ 🤦‍♀️
            matrix[i][j] = -1;
            System.out.println(String.format("%d, %d", i, j));
            }
        }
    }
}
