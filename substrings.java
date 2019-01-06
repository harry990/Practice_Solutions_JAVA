import java.util.*;
public class substrings {
	public int lengthOfLongestSubstring(String s) {
		// no repeat
		//Time is O(n).
		//Space is O(n).
	    if(s==null||s.length()==0){
	        return 0;
	    }
	    int result = 0,start=0;
	    HashMap<Character,Integer> hm = new HashMap<>();
	    for(int i=0; i<s.length(); i++){
	        if(hm.containsKey(s.charAt(i))){
	        	start = Math.max(hm.get(s.charAt(i)), start);
	        }
	        result=Math.max(result, i-start+1);
	        hm.put(s.charAt(i),i+1);
	    }
	 
	    return result;
	}
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		//at most two distint
		//Time is O(n).
	    int result = 0;
	    int i=0;
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    for(int j=0; j<s.length(); j++){
	        char c = s.charAt(j);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	 
	        if(map.size()<=k){
	            result = Math.max(result, j-i+1);
	        }else{
	            while(map.size()>k){
	                char l = s.charAt(i);
	                int count = map.get(l);
	                if(count==1){
	                    map.remove(l);
	                }else{
	                    map.put(l, map.get(l)-1);
	                }
	                i++;
	            }
	        }
	 
	    }
	 
	    return result;
	}

}
