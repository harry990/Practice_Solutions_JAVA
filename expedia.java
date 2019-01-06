import java.util.Arrays;

public class expedia {
/*
	public String[] solution(String[] input, int n) {
		// TODO Auto-generated method stub
		String[] output = new String[n];
		int max_len = 0;
		
		while(i!=n) {
			curr_string = input[n]i
			if (curr_string.length)
		}
	}
	*/
	//#include <bits/stdc++.h>
	//using namespace std;

	/*
	public boolean custom(String a, String b) {
	  return a.length() < b.length();
	}
	*/
	 public static String[] sortStrings(String[] array){
		    //sort arrays by length before returning
		    Arrays.sort(array,(a,b) -> Integer.compare(a.length(),b.length()));
		    return array;
		}

	public static boolean solve(String[] s) {
	  boolean ok = true;
	  for (int i = 1; i < s.length; i++) {
	    for (int j = 0; j < i; j++) {
	      //if (s[i].find(vs[j]) == string::npos) {
	      if (!s[i].toLowerCase().contains(s[j].toLowerCase())) {
	        ok = false;
	        break;
	      }
	    }
	  }
	  return ok;
	}

	public static void main(String[] args) {
		//String[] s = {"a", "d","aba", "abacaba", "ba","aba"};
		String[] s = {"homeaway", "homeaways","expedia"};
	  s = sortStrings(s);
	  boolean ok = solve(s);
	  if (ok) {
	    //cout << "YES" << "\n";
		System.out.println("YES");
	    for (String str: s) {
	      //System.out.println("string is:");
	      System.out.println(str);
	      //cout << s << "\n";
	    }
	  } else {
		  System.out.println("NO");
		  //cout << "NO" << "\n";
	  }
	}


}
