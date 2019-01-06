import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 71. Simplify Path
//ignore . ; ignore path before ..
public class simplifyPath {
	public String simplifyLocalPath(String path) {
        if (path == null) return path;
        
        Stack<String> pathStack = new Stack<String>();
        String[] tokens = path.split("/");
        
        for (String s : tokens){
           if (s.equals("..")) {
        	   if (!pathStack.isEmpty()) pathStack.pop();
           } else if (!s.equals(".")) {
        	   if (!s.isEmpty()) pathStack.push(s);
           }
        }
        
        List<String> list = new ArrayList<String>(pathStack);
        return "/"+String.join("/", list);
        
    }
	public static void main (String[] args) 
    { 
		simplifyPath newOb = new simplifyPath();
        
		//String path = "/otherdir/home/";
		//String path = "/a/./b/../../c/";
		//String path = "/a/../../b/../c//.//";
		//String path = "/a//b////c/d//././/..";
		//String path = "/../";
		//String path = "/home//foo/";
		String path = " ";
		System.out.println(newOb.simplifyLocalPath(path));

    }
}
