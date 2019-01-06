/*
The idea was firstly transpose the matrix and then flip it symmetrically. 
After transpose, it will be swap(matrix[i][j], matrix[j][i]).
Then flip the matrix horizontally. 
(swap(matrix[i][j], matrix[i][matrix.length-1-j])

For instance,

1  2  3      1  4  7     7  4  1 
4  5  6  ==> 2  5  8 ==> 8  5  2
7  8  9      3  6  9     9  6  3

 */
public class rotateImage {
	public int[][] rotate(int[][] matrix) {
		if (matrix==null || matrix.length == 0 || matrix[0].length == 0) return matrix;
		for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
	    return matrix;
	}
	
	public static void main (String[] args) 
    { 
		rotateImage sl = new rotateImage();
	
	    int[][] matrix = {{1, 3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50},{2,3,4,6}};
	    //int[][] matrix = {{3},{4}};
	    //int[][] matrix = {{},{}};
	    //int[][] matrix = {{1}};
	    //int[][] matrix = {{1,3}};
	    //int[][] matrix = {{}};
		System.out.println(sl.rotate(matrix));
    }
}
