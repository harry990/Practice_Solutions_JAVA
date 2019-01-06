import java.util.LinkedList;
import java.util.List;

public class grayCodeGenerator {
	public List<Integer> grayCode(int n) {
				
	    List<Integer> solution = new LinkedList<>();
	    // right shift - divide by 2
	    for (int i = 0; i < 1<<n; i++) solution.add(i ^ i>>1);
	    //for (int i = 0; i < Math.pow(2,n); i++) solution.add(i ^ i/2); 
	    return solution;
	}	
	public static void main (String[] args) 
    { 
		grayCodeGenerator newOb = new grayCodeGenerator();
        
		int n = 10;
		List<Integer> out = newOb.grayCode(n);
		for (int a:out)
			System.out.println(a);
    }
}
