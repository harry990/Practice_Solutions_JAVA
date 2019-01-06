import java.util.LinkedList;
import java.util.List;

public class sortIntervals {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { 
	    	  start = s; 
	    	  end = e;
	      }
	 }
	
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
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public void QuickSort(List<Interval> arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            QuickSort(arr, low, pi-1); 
            QuickSort(arr, pi+1, high); 
        } 
    }
    
    public static void main (String[] args) 
    { 
    	sortIntervals newOb = new sortIntervals();
        
		//[[1,9],[2,5],[19,20],[10,11],[12,20],[0,3],[0,1],[0,2]]
		List<Interval> arr = new LinkedList<Interval>();
		Interval i = newOb.new Interval(3,9);
		arr.add(i);
		i = newOb.new Interval(2,5);
		arr.add(i);
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
		
		newOb.QuickSort(arr,0,arr.size()-1);
		
		for (Interval a:arr)
			System.out.println(a.start+" and "+a.end);
    }
}