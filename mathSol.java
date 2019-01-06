
public class mathSol {
	public double myPow(double x, int n) {
		long n_long = n;
        return helper(x, n_long);
    }
    
    private double helper(double x, long n) {
    	if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? helper(x*x, n/2) : x*helper(x*x, n/2);
	}
	public static void main (String[] args) 
    { 
		mathSol newOb = new mathSol();

		System.out.println(newOb.myPow(0, -1));
    }
}
