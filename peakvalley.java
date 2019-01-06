import java.util.*;
public class peakvalley {
	  public int solution(int[] A) {
	    int n = A.length;
	    int cnt=0;
	    int flag=0;
	    int singleton=1;
	    
	    if (A.length==1) return 1;
	    if (A.length==2 && A[0]!=A[1]) return 2;
	    
	    // Find all the peaks
	    for(int i = 1; i < n-1; i++){
	      if(A[i] > A[i-1] && A[i] > A[i+1]) cnt++;
	      if(A[i] == A[i-1] && A[i] > A[i+1] && flag==1) {
	    	  cnt++;
	    	  flag=0;
	      }
	      if(A[i] > A[i-1] && A[i]==A[i+1]) flag=1;
	      
	      if(A[i]!=A[i-1]) singleton=0;
	    }
	    
	    if (singleton!=1) {
		    flag=0;
		    // Find all the valleys
		    for(int i = 1; i < n-1; i++){
		      if(A[i] < A[i-1] && A[i] < A[i+1]) cnt++; 
		      if(A[i] == A[i-1] && A[i] < A[i+1] && flag==1) {
		    	  cnt++;
		    	  flag=0;
		      }
		      if(A[i] < A[i-1] && A[i]==A[i+1]) flag=1;
		    }
		    
		    // plus 2 for start and end
		    return cnt+2;
	    } else return 1;
	 }
	 
	  public static void main (String[] args) 
	    { 
	    	peakvalley newOb = new peakvalley();

	    	//int[] a = {2,2,3,4,3,3,2,2,1,1,2,5};
	    	int[] a = {-3,3};
			int b = newOb.solution(a);
			System.out.println("OUTPUT " + b);
	    }
}
