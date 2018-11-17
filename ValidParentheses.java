import java.util.Stack;

public class ValidParentheses {
	    public boolean isValid(String s) {
	        if (s.length()==0 || s==null){return true;}
	        
	        Stack<Character> bracket = new Stack<Character>();
	        
	        for (char c : s.toCharArray()){
	            if (c=='('){
	                bracket.push(')');
	            } else if (c=='{'){
	                bracket.push('}');
	            } else if (c=='['){
	                bracket.push(']');
	            } else if (bracket.isEmpty() || bracket.pop() != c){
	                return false;
	            }
	        }
	        return bracket.isEmpty();
	    }
}
