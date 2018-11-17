
public class FindClosestNumber {
	// finds the closest number from a SORTED array given a single number.
	     public static int search() {
	         
	         int value = 27;
	         int[] a = new int[] {1,6,10,18,28};

	        if(value < a[0]) {
	            return a[0];
	        }
	        if(value > a[a.length-1]) {
	            return a[a.length-1];
	        }

	        int lo = 0;
	        int hi = a.length - 1;

	        while (lo <= hi) {
	            int mid = (hi + lo) / 2;

	            if (value < a[mid]) {
	                hi = mid - 1;
	            } else if (value > a[mid]) {
	                lo = mid + 1;
	            } else {
	                return a[mid];
	            }
	        }
	        // lo == hi + 1
	        return (a[lo] - value) < (value - a[hi]) ? a[lo] : a[hi];
}
public static void main(String[] args){
	        System.out.println(search());
	    }
}
