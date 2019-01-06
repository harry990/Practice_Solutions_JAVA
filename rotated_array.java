
public class rotated_array {
	 public int search(int[] nums, int target) {
	        int lo = 0;
	        int hi = nums.length-1;
	        
	        while(lo<hi) {
	        	int mid = (hi+lo)/2;
	        	if (nums[mid]>nums[hi]) {
	        		lo = mid + 1;
	        	} else {
	        		hi = mid;
	        	}
	        }
	        
	        int origin = lo;
	        lo = 0;
	        hi = nums.length-1;
	        
	        while(lo<=hi) {
	        	int mid = (hi+lo)/2;
	        	// check for original mid which is a certain number bfr
	        	// fake mid
	        	int true_mid = (mid+origin)%nums.length;
	        	if (nums[true_mid]==target) return true_mid;
	        	if (nums[true_mid]<target) lo = mid+1;
	        	else hi = mid-1;
	        }
	        
	        return -1;
	 }
	 public static void main (String[] args) 
	    { 
		   rotated_array r = new rotated_array();
	    	int arr[] = {7,8,9,12,0,1,3,5,6}; 
	    	//int arr[] = {3,3}; 
	        int n = 2;
	        //int o[] = r.search(arr, n);
	        System.out.println(r.search(arr,n)); 
	    } 
}
