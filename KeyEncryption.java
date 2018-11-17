
public class KeyEncryption {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");
	    public String solution(String S, int K) {
	        // write your code in Java SE 8
	        //int dash_count = 0;
	        //keep count of dashes
	        //for(int i = 0; i<S.length(); i++){
	        //    if (S.charAt(i) == '-') {
	        //       dash_count++;
	        //    }
	       // }
	        
	        //int act_dash = (int) Math.ceil((S.length() - dash_count) / K) - 1;
	        //String[] letters = new String[S.length()-dash_count+act_dash];
	        String letters = new String();
	        
	        int i1 = S.length() - 1;
	        //int i2 = letters.length;
	        int cnt = 0;
	        while(i1>=0){
	            if (cnt == K){
	                letters = "-" + letters;
	                //i2++;
	                cnt = 0;
	            } else {
	                if(S.charAt(i1) != '-'){
	                    letters = S.charAt(i1) + letters;
	                    //i2++;
	                    cnt++;
	                } 
	                i1--;
	            }
	                
	        }
	        return letters.toUpperCase();
	    }
}
