
public class Google2 {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	    public int[] solution(int[] stores, int[] houses) {
	        // write your code in Java SE 8
	        // WC Complexity - O(slogs + hlogs) 
	        // s - num of stores, h = num of houses
	        
	        // Output
	        int[] output = new int[houses.length];
	        
	        //sort stores here -  counQuck Sort - O(nlogn)
	        stores = myQuickSort(stores, 0, stores.length - 1);
	        
	        //find nearest store for every house
	        for(int i = 0; i<houses.length; i++){
	            output[i] = find_nearest_store(houses[i],stores);
	        }
	        return output;
	    }
	    
	    // This function gives nearest integer to a number in a given sorted array
	    public int find_nearest_store(int num, int a[]) {
		 
	        //handle edge cases
	        if(num < a[0]) {
	            return a[0];
	        }
	        if(num > a[a.length-1]) {
	            return a[a.length-1];
	        }

	        // define lo and hi variables
	        int lo = 0;
	        int hi = a.length - 1;

	        // go from each end and keep checking which one is nearer
	        while (lo <= hi) {
	            int mid = (hi + lo) / 2;
	            // check if the value is mid value else move corresponding pointer
	            if (num < a[mid]) {
	                hi = mid - 1;
	            } else if (num > a[mid]) {
	                lo = mid + 1;
	            } else {
	                return a[mid];
	            }
	        }
	        //return the integer with lower difference
	        return (a[lo] - num) < (num - a[hi]) ? a[lo] : a[hi];
	    }

	    // This performs quicksort
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
