import java.util.*;

public class graphRoutines {
	/**
	 * Definition for undirected graph.
	 **/
	class UndirectedGraphNode {
	    int label;
	    List<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	//****************** Clone Graph - deep copy ****************** 
	Map<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null) return null;
		
		UndirectedGraphNode curr = new UndirectedGraphNode(node.label);
		// store corresponding current node to original graph node
		hm.put(node, curr);
		for (UndirectedGraphNode peer: node.neighbors) {
			// if peer not visited yet, make its clone 
			if(!hm.containsKey(peer)) {
				cloneGraph(peer);
			}
			// add original neighbors of node as neighbors of curr
			curr.neighbors.add(hm.get(peer));
		}
		return curr;
	}
}
