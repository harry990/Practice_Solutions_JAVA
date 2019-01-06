import java.util.*;

public class snippets {
	public void snippet_list() {
		
		//num array to joined string
		int nums[] = {1,2,3,4};
		String out_string;
		
		StringBuilder sb = new StringBuilder();
	    for(int p : nums) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    out_string = sb.length() == 0 ? "0" : sb.toString();
	    System.out.println(out_string);
	    
        // Temp
	    int[] arr1 = new int[4];
	    int[] arr2 = {1,2,3,4};
	    int n1 = 2;
	    int n2 = 3;
	    String s = "sample";
	    
	    // row column
	    int[][] matrix = new int[4][4];
	    int R = matrix.length;
        int C = matrix[0].length;
	    
	    // Init
	    List<List<Integer>> l1 = new ArrayList<>();
	    List<Integer> l2 = new LinkedList<>();
	    List<Integer> l3 = new ArrayList<>();
	    Map<Integer,List<String>> hm = new HashMap<Integer,List<String>>();
	    // hm.containsKey(key)
	    Set<Integer> set = new HashSet<Integer>();
	    // set.contains(val)
	    Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
	    // ht.containsKey(key)
	    Queue<Integer> q = new LinkedList<Integer>();
	    //q.peek(); q.remove(); q.add(); q.poll(); q.contains();
	    Stack<Integer> st = new Stack<Integer>();
	    l1.add(Arrays.asList(1,2,3));
	    
	    // Shorts
	    Arrays.fill(arr1,0);
	    Arrays.sort(arr2);
	    Integer.compare(n1,n2);
	    char[] out = new char[s.length()];
	    char[] c = s.toCharArray();
	    int key = Arrays.hashCode(arr2);

	    
	    //Bit manipulation
	    // XOR ("this or that, but not both!")
	    // a XOR a = 0;
	    // a XOR 0 = a;
	    int a = 3;
	    int b = 1;
	    int res1 = a^a;
	    int res2 = a^0;
	    a ^=b; // means g = g^b
	    
	    //Unary bitwise complement operator [~] - flip all bits
	    int z = ~32;
	    
	    // Returns
	    // return new int[] {i,j};
	    
	}
	
	private void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
	
	public static void main (String[] args) 
    { 
		snippets newOb = new snippets();

		newOb.snippet_list();
		System.out.println("OUTPUT");
    }
}
