import java.util.*;
public class multiply_strings {
	// https://leetcode.com/problems/multiply-strings/
    public String multiply(String num1, String num2) {
        /*
         out[5] = 2*2
         out[4] = 2*1 + 1*2 + carry
         out[3] = 2*0 + 1*1 + 0*2 + carry
         out[2] =       1*0 + 0*1 + carry
         out[1] =             0*1 + carry
         out[0] =                   carry
         
        *--------------------------------------*
                 1    2    3  ---> n2
                 4    5    6  ---> n1
                -------------
                 7    3(1) 8(1)
             6   1(1) 5(1) +
         4   9   2(1) +    +
         -----------------------
         5   6   0    8    8
         
                 4    5    6  ---> n2
         		 1    2    3  ---> n1
                -------------
             1   3(1) 6(1) 8(1)
             9   1(1) 2(1) +
         4   5   6    +    +
         -----------------------
         5   6   0    8    8
         
        */
    	 if (num1.length()==0 || num2.length()==0 || num1=="0" || num2=="0") return "0";
        
    	 int n1 = num1.length();
    	 int n2 = num2.length();
         int output[] = new int[n1+n2];
         Arrays.fill(output, 0);
         //for (int i=0;i<n1+n2-1;i++) {
        //	 output[i] = 0;
         //}
         int carry = 0;
         //int old_carry = 0;
         
         for (int i=n1-1;i>=0;i--) {
        	 int k = i+n2;
        	 for (int j=n2-1;j>=0;j--) {
        		 int val = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
        		 output[k]=output[k]+val+carry;
        		 if (output[k]/10 > 0) {
            		 carry = output[k]/10;
        			 output[k]=output[k]%10;
        		 } else {
        			 carry = 0;
        		 }
        		 if (j==0 & carry>0) {
        			 output[k-1] = carry;
        			 carry = 0;
        		 }
        		 k = k-1;
        	 }
         }
         
         StringBuilder sb = new StringBuilder();
         for(int p : output) if(!(sb.length() == 0 && p == 0)) sb.append(p);
         return sb.length() == 0 ? "0" : sb.toString();
         
       }
    
	    public static void main (String[] args) 
	    { 
	    	multiply_strings ms = new multiply_strings();
	
			System.out.println(ms.multiply("99","123"));
	    }
}
