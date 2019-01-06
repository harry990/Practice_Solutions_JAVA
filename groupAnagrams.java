
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {
	 public List<List<String>> groupAllAnagrams(String[] strs) {
	       if (strs.length == 0) return new ArrayList<List<String>>();
	       
	       //Map<String,List<String>> sol = new HashMap<String,List<String>>();
	       Map<Integer,List<String>> sol = new HashMap<Integer,List<String>>();
	       int[] counter = new int[26]; //total alphabet
	       
		   for (String s : strs) {
			 Arrays.fill(counter,0);
			 for (char c:s.toCharArray()) counter[c-'a']++; //adding count of each character
			 
			 /*
			 StringBuilder sb = new StringBuilder("");
			 for (int i=0;i<26;i++) {
				 sb.append('#'); // for leading zeroes
				 sb.append(counter[i]);
			 }
			 
			 String key = sb.toString();
			 */
			 
			 int key = Arrays.hashCode(counter);
			 
			 // store in hash table for existing combinations
			 if (!sol.containsKey(key)) sol.put(key, new ArrayList<String>());
			 sol.get(key).add(s);
		   }
		   
		   return new ArrayList<List<String>>(sol.values());
	 }
		public static void main (String[] args) 
	    { 
			groupAnagrams newOb = new groupAnagrams();
	        
			String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
			List<List<String>> out = newOb.groupAllAnagrams(arr);
			for (List<String> a : out)
				System.out.println(a);
			}
}
