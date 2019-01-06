// Find D Ancestor in path to root
public class Google1 {

	//you can also use imports, for example:
	//import java.util.*;

	//you can write to stdout for debugging purposes, e.g.
	//System.out.println("this is a debug message");

	 public int[] solution(int D, int[] A) {
	     // write your code in Java SE 8
	     // WC Complexity - O(Dn)
	     
	     // Initialize output
	     int[] output = new int[A.length];
	     
	     // For every value in A, search for D nearest neighbour
	     for(int i =0; i<A.length; i++){
	         
	         int val = i;
	         int count = 0;
	         // Go up the tree for D ancestors or until root is hit
	         while(count < D){
	             val = A[val];
	             count++;
	             // Root has been hit - no valid ancestors
	             if(val == -1){
	                 break;
	             }
	         }
	         output[i] = val;
	     }
	     return output;
	 }
}
