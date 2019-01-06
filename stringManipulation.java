
public class stringManipulation {
	public String reverse(String s) {
		if (s==null) return s;
		char[] out = new char[s.length()];
		
		int j = 0;
		for(int i=s.length()-1;i>=0;i--) {
			out[j]=s.charAt(i);
			j++;
		}
		
		//System.out.println(out.toString());
		//return out.toString();
		return new String(out);
	}
	public static void main (String[] args) 
    { 
		stringManipulation newOb = new stringManipulation();

		System.out.println(newOb.reverse("output"));
    }
}
