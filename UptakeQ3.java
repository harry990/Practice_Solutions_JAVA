import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
public class UptakeQ3 {
	public class Tree {
		int x;
		Tree l;
		Tree r;
	}
    public int solution(Tree T) {
		if(T == null){
			return 0;
		}
		
        Set<Integer> uniq = new HashSet<Integer>();
		//return getMaxHelper(T, uniq);
		
        //Hashtable<Integer,Integer> uniq = new Hashtable<Integer,Integer>();
        return getMax(T, uniq);
	}
	
	private static int getMaxHelper(Tree root, Set<Integer> uniq){
		if(root == null){
			return uniq.size();
		}
		int lf = 0;
		int ri  = 0;
		if(uniq.add(root.x)){
			lf = getMaxHelper(root.l, uniq);
			ri = getMaxHelper(root.r, uniq);
			uniq.remove(uniq.size()-1);
		}
		else{
			lf = getMaxHelper(root.l, uniq);
			ri = getMaxHelper(root.r, uniq);
		}
		return Math.max(lf, ri);
	}
	
	//O(n)
	private int getMax(Tree root,  Set<Integer> uniq) {
		if(root == null){
			return uniq.size();
		}
		boolean isUniq;
		
		if (!uniq.contains(root.x)) {
			uniq.add(root.x);
			isUniq = true;
		} else {
			isUniq = false;
		}
		
		int max_path = Math.max(getMax(root.l,uniq),getMax(root.r, uniq)); 
		
		if (uniq.contains(root.x) && isUniq)
			uniq.remove(root.x);
		
		return max_path; 
	}
	
	public static void main (String[] args) 
    { 
		UptakeQ3 newOb = new UptakeQ3();

		Tree T1 = newOb.new Tree();
		Tree T2 = newOb.new Tree();
		Tree T3 = newOb.new Tree();
		Tree T4 = newOb.new Tree();
		Tree T5 = newOb.new Tree();
		Tree T6 = newOb.new Tree();
		Tree T7 = newOb.new Tree();
		T1.x = 4;
		T2.x = 5;
		T3.x = 6;
		T4.x = 11;
		T5.x = 1;
		T6.x = 6;
		T7.x = 7;
		
		T1.l = T2;
		T1.r = T3;
		
		T2.l = T4;
		T2.r = null;
		
		T3.l = null;
		T3.r = T6;
		
		T4.l = T7;
		T4.r = null;
		
		T5.l = null;
		T5.r = null;
		
		T6.l = null;
		T6.r = null;
		
		T7.l = T5;
		T7.r = null;
		
		System.out.println(newOb.solution(T1));
    }
	
}