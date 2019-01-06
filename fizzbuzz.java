
public class fizzbuzz {
	public void printFizzBuzz(int n) {
		if (n==0) System.out.println(0);
		String a="Fizz";String b="Buzz";
		
		for (int i=1;i<=n;i++) {
			if(i%3==0 && i%5==0) System.out.println(a+b);
			else if(i%3==0) System.out.println(a);
			else if(i%5==0) System.out.println(b);
			else System.out.println(i);
		}
	}
	public static void main (String[] args) 
    { 
		fizzbuzz newOb = new fizzbuzz();
		newOb.printFizzBuzz(10);
    }
}
