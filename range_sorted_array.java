
public class range_sorted_array {
	    public int[] searchRange(int[] nums, int target) {
	    	int orange[] = {-1,-1};
	    	if (nums.length == 0){return orange; }
	        
	        // find start
	        orange[0] = find_leftmost(nums,target);
	        
	        // find end
	        orange[1] = find_rightmost(nums,target);
	        
	        return orange;
	        //return find_range(nums,target);
	    }
	    
	    /*
	    public int[] find_range(int[] A, int t){
	    	int lo = 0;
	    	int hi = A.length;
	    	int mid =  lo + (hi-lo)/2;
	        int index[] = {-1,-1};
	        int first_match = -1;
	        while(lo<hi){
	            if (A[mid]<t){
	                lo = mid+1;
	            } else if (A[mid]>t){
	                hi = mid;
	            } else {
	                hi = mid;
	                index[0] = mid;
	                if (first_match==-1) {
	                	first_match = index[0];
	                }
	            }
	            //System.out.println(index);
	            mid = lo + (hi-lo)/2;
	            //index = find_leftmost(A,t,lo,hi);
	        }
	        
	        if (first_match == -1) {
	        	return index;
	        } else if (first_match+1>=A.length) {
	        	index[1] = first_match;
	        } else if (A[first_match+1]==t) {
	        	lo = first_match;
		    	hi = A.length;
		        mid =  lo + (hi-lo)/2;
		        while(lo<hi){
		            if (A[mid]<t){
		                lo = mid+1;
		            } else if (A[mid]>t){
		                hi = mid;
		            } else {
		                lo = mid+1;
		                index[1] = mid;
		            }
		            //System.out.println(index);
		            mid =  lo + (hi-lo)/2;
		            //index = find_rightmost(A,t,lo,hi);
		        }
	        } else {
	        	index[1] = first_match;
	        }
	        //System.out.println(index);
	        return index;
	    }
	    */
	    public int find_leftmost(int[] A, int t){
	    	int lo = 0;
	    	int hi = A.length-1;
	    	int mid =  (hi-lo)/2;
	        while(lo+1<hi){
	            if (A[mid]>=t){
	                hi = mid;
	            } else {
	                lo = mid;
	            }
	            //System.out.println(index);
	            mid = lo + (hi-lo)/2;
	        }
	        //System.out.println(index);
	        if (A[lo]==t) {return lo;}
	        else if (A[hi]==t) {return hi;}
	        else return -1;
	    }
	    
	    public int find_rightmost(int[] A, int t){
	    	int lo = 0;
	    	int hi = A.length-1;
	        int mid =  (hi-lo)/2;
	        while(lo+1<hi){
	            if (A[mid]<=t){
	                lo = mid;
	            } else {
	                hi = mid;
	            }
	            //System.out.println(index);
	            mid =  lo + (hi-lo)/2;
	            //index = find_rightmost(A,t,lo,hi);
	        }
	        if (A[hi]==t) {return hi;}
	        else if (A[lo]==t) {return lo;}
	        else return -1;
	    }
	    
	    /*Driver function to check for above function*/
	    public static void main (String[] args) 
	    { 
	    	range_sorted_array r = new range_sorted_array();
	    	//int arr[] = {1,1,2,2,2,3,3,3,3,3,3,4,4,5,6,7,7}; 
	    	int arr[] = {3,3}; 
	        int n = 3;
	        int o[] = r.searchRange(arr, n);
	        System.out.println(o[0]); 
	        System.out.println(o[1]); 
	    } 
}
