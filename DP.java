import java.util.ArrayList;
import java.util.List;

public class DP {
	/*
	 The assumptions are,
	    When (n==0||m==0) the function always returns
	    1 since the robot can't go left or up.
		For all other cells,
		The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
		Therefore I populated the edges with 1 first and 
		use DP to get the full 2-D array.
	 */
	public int uniquePaths1(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n= obstacleGrid[0].length;
        
        // base case - starting block is obstacle - trivial
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        
        // 1st column
        for(int i = 1; i<m;i++){
           if (obstacleGrid[i][0]==0 && obstacleGrid[i - 1][0]==1) obstacleGrid[i][0] = 1; 
           else obstacleGrid[i][0] = 0;
        }
        // first row
        for(int j=1;j<n;j++){
           if (obstacleGrid[0][j]==0 && obstacleGrid[0][j - 1]==1) obstacleGrid[0][j] = 1;
            else obstacleGrid[0][j] = 0;
        }
        // rest
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    
    }
	// Triangle with min sum
	public int minimumTotal(List<List<Integer>> triangle) {
		// size is of the lowest row's num of elements + 1
		// triangle.size because lowest row will have the same
		// number of elements as the total height.
        int[] A = new int[triangle.size()+1];
        
        // go thru each row
        for(int i=triangle.size()-1;i>=0;i--) {
        	// go thru each element
        	for(int j=0;j<triangle.get(i).size();j++) {
        		// update each element
        		A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        	}
        }
        return A[0];
        
    }
	public static void main (String[] args) 
    { 
		DP newOb = new DP();

		//System.out.println(newOb.uniquePaths1(12,13));
		List<List<Integer>> arr = new ArrayList<>(4);
		List<Integer> temp1 = new ArrayList<>(1);
		temp1.add(2);
		arr.add(temp1);
		List<Integer> temp2 = new ArrayList<>(2);
		temp2.add(3); temp2.add(1);
		arr.add(temp2);
		List<Integer> temp3 = new ArrayList<>(3);
		temp3.add(6); temp3.add(5); temp3.add(2);
		arr.add(temp3);
		List<Integer> temp4 = new ArrayList<>(4);
		temp4.add(4); temp4.add(11); temp4.add(8); temp4.add(1);
		arr.add(temp4);
		//[[2],[3,4],[6,5,7],[4,1,8,3]]
		
		System.out.println(newOb.minimumTotal(arr));
    }
}
