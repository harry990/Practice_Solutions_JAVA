
public class set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
    	int R = matrix.length;
        int C = matrix[0].length;
        boolean col1 = false;
        boolean row1 = false;
        
        for (int i = 0; i<C;i++){
            if (matrix[0][i] == 0) {
                row1 = true;
            }
        }
        for (int i = 0; i<R;i++){
            if (matrix[i][0] == 0) {
                col1 = true;
            }
        }
        for (int i = 1; i<R;i++){
            for (int j = 1; j<C;j++){
                if (matrix[i][j] == 0) {
                  matrix[0][j] = 0;
                  matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                  matrix[i][j] = 0;
                }
            }
        }
        
        if (row1) {
          for (int i = 0; i < C; i++) {
            matrix[0][i] = 0;
          }
        }
        if (col1) {
          for (int i = 0; i < R; i++) {
            matrix[i][0] = 0;
          }
        }
    
    
    }
}
