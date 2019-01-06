/*
 This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class Missing_integer {
	public int solution(int[] A) {
        // write your code in Java SE 8
        //sort list
        A = myQuickSort(A,0,A.length-1);
        
        if (A[A.length-1]<=0) return 1;
        
        for(int i = 1;i<A.length;i++){
            if(A[i]>1){
                if(A[i]!=A[i-1]+1){
                    return A[i-1]+1;
                }
            }
        }
        return A[A.length-1]+1;
    }
    
    public int[] myQuickSort(int a[], int lo, int hi)
	    { 
	        if (lo < hi) 
	        { 
	            //Get a pivot - we take last element
	            int pivot = a[hi];  
	            // Pointer to small
	            int i = (lo-1); 
	            for (int j=lo; j<hi; j++) 
	            { 
	                // if smaller/equal to pivot then swap positions
	                if (a[j] <= pivot) 
	                { 
	                    i++; 
	                    int temp = a[i]; 
	                    a[i] = a[j]; 
	                    a[j] = temp; 
	                } 
	            } 
	      
	            int temp = a[i+1]; 
	            a[i+1] = a[hi]; 
	            a[hi] = temp;
	  
	            // Recursively qucksort on the two parts of the divided array
	            myQuickSort(a, lo, i); 
	            myQuickSort(a, i+2, hi); 
	        } 
	        return a;
	    }
}
