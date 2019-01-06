//import java.util.Collections;
//import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class mergeIntervals {
		
		//Definition for an interval.
		public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { 
		    	  start = s; 
		    	  end = e;
		      }
        }
	
		/* Inbuilt  
	    private class IntervalComparator implements Comparator<Interval> {
	        @Override
	        public int compare(Interval a, Interval b) {
	            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
	        }
	    }
	    */
		
		public int partition(List<Interval> arr, int low, int high) 
	    { 
	        Interval pivot = arr.get(high);  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	            // If current element is smaller than or 
	            // equal to pivot 
	            if (arr.get(j).start < pivot.start) { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                Interval temp = arr.get(i); 
	                arr.set(i, arr.get(j)); 
	                arr.set(j, temp); 
	            } else if (arr.get(j).start == pivot.start) { 
	            	if (arr.get(j).end >= pivot.end) {
	            		i++; 
	            		  
	                    // swap arr[i] and arr[j] 
	                    Interval temp = arr.get(i); 
	                    arr.set(i, arr.get(j)); 
	                    arr.set(j, temp); 
	            	}
	            }
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        Interval temp = arr.get(i+1); 
	        arr.set(i+1, arr.get(high)); 
	        arr.set(high, temp);
	  
	        return i+1; 
	    } 
	  
	  
	    // The main function that implements QuickSort() 
	    public void QuickSort(List<Interval> arr, int low, int high) 
	    { 
	        if (low < high) 
	        { 
	            int pi = partition(arr, low, high); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            QuickSort(arr, low, pi-1); 
	            QuickSort(arr, pi+1, high); 
	        } 
	    }
	    
		//nlogn for sorting
	    public List<Interval> merge(List<Interval> intervals) {
	    	 if (intervals.size() <= 1) return intervals;
	    	
	    	 //Collections.sort(intervals,new IntervalComparator());
	    	 
	    	 QuickSort(intervals,0,intervals.size()-1);
	    	 LinkedList<Interval> resList = new LinkedList<Interval>();
	    	 
	    	 for (Interval i : intervals) {
	    		 if (resList.isEmpty() || resList.getLast().end<i.start) {
	    			 resList.add(i);
	    		 } else {
	    			 resList.getLast().end = Math.max(resList.getLast().end,  i.end);
	    		 }
	    	 }
	    	
	        return resList;
	    }
	    
		public static void main (String[] args) 
	    { 
			mergeIntervals newOb = new mergeIntervals();
	        /*
			//[[1,3],[2,6],[8,10],[15,18]] - [[1,6],[8,10],[15,18]]
			//[[1,2],[3,4],[5,6],[8,9],[1,10]] - [[1,10]]
			List<Interval> arr = new LinkedList<Interval>();
			Interval i = newOb.new Interval(1,3);
			arr.add(i);
			i = newOb.new Interval(2,6);
			arr.add(i);
			//i = newOb.new Interval(5,10);
			//arr.add(i);
			i = newOb.new Interval(8,10);
			arr.add(i);
			i = newOb.new Interval(15,18);
			arr.add(i);*/
			
			//[[1,9],[2,5],[19,20],[10,11],[12,20],[0,3],[0,1],[0,2]]
			List<Interval> arr = new LinkedList<Interval>();
			Interval i = newOb.new Interval(3,9);
			arr.add(i);
			//i = newOb.new Interval(2,5);
			//arr.add(i);
			i = newOb.new Interval(19,20);
			arr.add(i);
			i = newOb.new Interval(10,11);
			arr.add(i);
			i = newOb.new Interval(12,20);
			arr.add(i);
			i = newOb.new Interval(0,4);
			arr.add(i);
			i = newOb.new Interval(0,2);
			arr.add(i);
			i = newOb.new Interval(0,1);
			arr.add(i);
			
			List<Interval> out = newOb.merge(arr);
			for (Interval a:out)
				System.out.println(a.start+" and "+a.end);
	    }
}
