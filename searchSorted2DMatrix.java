public class searchSorted2DMatrix {
	public int num_rows;
	public int num_cols;
	public int num_elements;
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) return false;
	    if(matrix[0] == null || matrix[0].length == 0) return false;
	    
	    num_rows = matrix.length; 
	    num_cols = matrix[0].length;
	    num_elements = num_rows*num_cols; 
 
        int output = binarySearch(matrix, 0, num_elements-1, target);
        if (output==-1) return false; else return true;
    }
    
    int binarySearch(int arr[][], int l, int r, int x) 
    { 
        if (r>=l) 
        { 
            int mid = l + (r - l)/2; 
  
            // If the element is present at the  
            // middle itself 
            int row = returnRow(mid);
            int col = returnCol(mid);
            //System.out.println(row + " R " + col + " C " + mid  + " M ");
            if (arr[row][col] == x) 
               return mid; 
  
            // If element is smaller than mid, then  
            // it can only be present in left subarray 
            if (arr[row][col] > x) 
               return binarySearch(arr, l, mid-1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid+1, r, x); 
        } 
  
        // We reach here when element is not present 
        //  in array 
        return -1; 
    } 
    // 1-D to 2-D indices
    int returnRow(int idx){
        return (idx/num_cols);
    }
    int returnCol(int idx){
       return (idx%num_cols); 
    }
    // 2-D to 1-D indices
    int returnIdx(int row, int col){
        return (row*num_cols)+col;
    }
	
	public static void main (String[] args) 
    { 
		searchSorted2DMatrix sl = new searchSorted2DMatrix();
	
	    //int[][] matrix = {{1, 3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
	    //int[][] matrix = {{3},{4}};
	    //int[][] matrix = {{},{}};
	    //int[][] matrix = {{1}};
	    int[][] matrix = {{1,3}};
	    //int[][] matrix = {{}};
	    int target = 3;
		System.out.println(sl.searchMatrix(matrix,target));
    }
}
