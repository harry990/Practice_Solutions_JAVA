import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
Breadth First or Level Order Traversal : 1 2 3 4 5

USES:
(a)Inorder:  Nodes in non-decreasing order for BST. 
(b)Preorder: Create a copy of the tree.
 			 Prefix expression of an expression tree. 
(c)Postorder:Delete the tree.
			 Postfix expression of an expression tree. 
 */
public class treeTraversals {
	// Root of Binary Tree 
	TreeNode root; 
	//constructor
    treeTraversals() 
    { 
        root = null; 
    } 
    
	public class TreeNode 
	{ 
	    int val; 
	    TreeNode left, right; 
	  
	    public TreeNode(int item) 
	    { 
	        val = item; 
	        left = right = null; 
	    } 
	} 
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
    /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
    void printPostorder(TreeNode node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.val + " "); 
    } 
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(TreeNode node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.val + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.left); 
  
        /* now recur on right subtree */
        printPreorder(node.right); 
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    int printInorder(TreeNode node) 
    { 
        if (node == null) 
            return 0; 
  
        /* first recur on left child */
        int sum = printInorder(node.left); 
  
        /* then print the data of node */
        //System.out.print(node.key + " "); 
        sum = sum + node.val;
  
        /* now recur on right child */
        sum = sum + printInorder(node.right); 
        
        
        return sum;
        
        /*
         * original * 
         printInorder(node.left);
         System.out.print(node.key + " ");
         printInorder(node.right);  
         */
    } 
    // alternate inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> out = new LinkedList<Integer>();
        if(root==null) return out;
        
        inorderT(root, out);
        return out;
    }
    public void inorderT(TreeNode root, List<Integer> out) {

        if(root==null) return;
        inorderT(root.left, out);
        out.add(root.val);
        inorderT(root.right, out); 
        
    }
    // Find mode
    private Integer prevVal=null;
    private int thisCnt=1;
    private int maxCnt=0;
    
    public void inOrderTrav(TreeNode root, List<Integer> list) {
    	if(root==null) return;
    	inOrderTrav(root.left,list);
    	 if (prevVal != null) {
             if (root.val == prevVal)
            	 thisCnt++;
             else
            	 thisCnt = 1;
         }
         if (thisCnt > maxCnt) {
        	 maxCnt = thisCnt;
             list.clear();
             list.add(root.val);
         } else if (thisCnt == maxCnt) {
             list.add(root.val);
         }
         prevVal = root.val;
    	inOrderTrav(root.right,list);
    }
    public int[] findMode(TreeNode root) {
    	if (root==null) return new int[0];
    	
    	List<Integer> list = new ArrayList<>();
        inOrderTrav(root,list);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }
  
    // Level order
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
  
    // Wrappers over above recursive functions 
    void printPostorder()  {printPostorder(root); } 
    int printInorder()    { int sum = printInorder(root); return sum;  } 
    void printPreorder()   {printPreorder(root);  } 
  
    // Valid BST TEST
    public boolean isBSTHelper(TreeNode node, Integer lo, Integer hi){
        if(lo!=null && node.val<=lo) return false;
        if(hi!=null && node.val>=hi) return false;
        
        boolean left = node.left != null ? isBSTHelper(node.left, lo, node.val) : true;
        if (left) {
            boolean right = node.right !=null ? isBSTHelper(node.right,node.val,hi) : true;
            return right;
        } else return false;
    }
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        
        return isBSTHelper(root, null, null);
    }
    
    private TreeNode prev = null;
    // Flatten BST to LinkedList   
    //       1
    //      / \
    //     2   5
    //    / \   \
    //   3   4   6
    //The flattened tree should look like:
	//  1
	//   \
	//    2
	//     \
	//      3
	//       \
	//        4
	//         \
	//          5
	//           \
	//            6
    public void flattenIN(TreeNode root) {
        if (root == null) return;
        
        flattenIN(root.right);
        flattenIN(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    //

    //TreeNode root; 
    // head --> Pointer to head node of created doubly linked list 
    TreeNode head; 
    void BT2DLL(TreeNode root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BT2DLL(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BT2DLL(root.right); 
    } 
    // Sorted Linked List to BST - recursion using array   - O(N) O(N)
    // O(nlogn) O(logn) - recursion without array  
    /*
    public List<Integer> elems;
    public TreeNode arrayToBST(int left, int right){
        if(left>right) return null;
        int mid = (right+left)/2;
        TreeNode node = new TreeNode(elems.get(mid));
        if(left==right) return node;
        
        node.left = arrayToBST(left,mid-1);
        node.right = arrayToBST(mid+1,right);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        elems = new ArrayList<Integer>();
        while(head!=null){
            elems.add(head.val);
            head=head.next;
        }
        return arrayToBST(0,elems.size()-1);
        
    }
    */
    // Sorted Linked List to BST - simulate inorder traversal  - O(N) O(logn)
    public ListNode head1;
    public int findSize(ListNode head){
        ListNode dummy = head;
        int cnt = 0;
        while(dummy!=null){
            dummy=dummy.next;
            cnt++;
        }
        return cnt;
    }
    public TreeNode arrayToBST(int left, int right){
        if(left>right) return null;
        int mid = (right+left)/2;
        
        // left
        TreeNode leftTree = arrayToBST(left,mid-1);
        
        // root
        TreeNode node = new TreeNode(this.head1.val);
        node.left=leftTree;
        this.head1=head1.next;
        
        // right
        node.right = arrayToBST(mid+1,right);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size=findSize(head);
        this.head1=head;
        return arrayToBST(0,size-1);
        
    }
    
     // Definition for binary tree with next pointer.
     public class TreeLinkNode {
          int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }
  
     // connect next right node - perfect tree
     public void connect(TreeLinkNode root) {
         
         if(root == null) return;
         
         /*
         TreeLinkNode level_start=root;
          while(level_start!=null){
              TreeLinkNode cur=level_start;
              while(cur!=null){
             	 // make siblings connection
                  if(cur.left!=null) cur.left.next=cur.right;
                  // make right child connection to next's left child
                  if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                  
                  cur=cur.next;
              }
              // keep going left
              level_start=level_start.left;
          }
          */
         
         if(root.left != null){
             root.left.next = root.right;
             if(root.next != null)
                 root.right.next = root.next.left;
         }

         connect(root.left);
         connect(root.right);
     }
  // connect next right node -  tree with empty child
     public void connectT(TreeLinkNode root) {
         
         while(root != null){
             TreeLinkNode tempChild = new TreeLinkNode(0);
             TreeLinkNode currentChild = tempChild;
             while(root!=null){
                 if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                 if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                 root = root.next;
             }
             root = tempChild.next;
         }
     }
     // build tree from preorder and inorder
     Map<Integer, Integer> inorder_hm = new HashMap<Integer,Integer>();
     public TreeNode buildTreePost(int[] inorder, int[] postorder) {
         for (int i = 0; i < inorder.length; i++) {
        	 inorder_hm.put(inorder[i], i);
         }
         return helperPost(postorder.length-1, 0, inorder.length - 1, postorder, inorder);
     }

     public TreeNode helperPost(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
         if (postEnd <0 || inStart > inEnd) return null;
         
         TreeNode root = new TreeNode(postorder[postEnd]);
         int inIdx = inorder_hm.get(root.val);
         //int inIdx = 0; 
         //for (int i = inStart; i <= inEnd; i++) {
         //    if (inorder[i] == root.val) inIdx = i;
         //}
         root.left = helperPost(postEnd - (inEnd-inIdx) - 1, inStart, inIdx - 1, postorder, inorder);
         root.right = helperPost(postEnd - 1, inIdx + 1, inEnd, postorder, inorder);
         return root;
     }
     public TreeNode buildTreePre(int[] preorder, int[] inorder) {
    	 for (int i = 0; i < inorder.length; i++) {
        	 inorder_hm.put(inorder[i], i);
         }
         return helperPre(0, 0, inorder.length - 1, preorder, inorder);
     }

     public TreeNode helperPre(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    	 if(preStart>preorder.length-1||inStart>inEnd) return null;
    	 
    	 TreeNode root = new TreeNode(preorder[preStart]);
    	 int inIdx = inorder_hm.get(root.val);
    	 /*
    	  int inIdx = 0;
    	 for(int i=inStart;i<inEnd;i++) {
    		 if (inorder[i]==root.val) inIdx = i;
    	 }
    	 */
    	 
    	 root.left = helperPre(preStart+1,inStart,inIdx-1,preorder,inorder);
    	 // preStart + numsOnLeft + 1
    	 root.right= helperPre(preStart+inIdx-inStart+1,inIdx+1,inEnd,preorder,inorder);
    	 return root;
     }
    
     // sum of aqll root to leaf numbers
     public int sumNumbers(TreeNode root) {
         return getSum(root,0);
     }
     public int getSum(TreeNode root, int sum) {
    	 if(root==null) return 0;
    	 
         if(root.right==null && root.left==null) return sum*10 + root.val;
         return getSum(root.left, sum*10+root.val)+getSum(root.right,sum*10+root.val);
     }
    // Driver method 
    public static void main(String[] args) 
    { 
        treeTraversals tree = new treeTraversals(); 
        TreeLinkNode root = tree.new TreeLinkNode(1); 
        root.left = tree.new TreeLinkNode(2); 
        root.right = tree.new TreeLinkNode(5); 
        root.left.left = tree.new TreeLinkNode(4); 
        root.left.right = tree.new TreeLinkNode(5); 
        root.right.left = tree.new TreeLinkNode(6); 
        root.right.right = tree.new TreeLinkNode(7); 
        
        //treeTraversals tree = new treeTraversals(); 
        tree.root = tree.new TreeNode(1); 
        tree.root.left = tree.new TreeNode(2); 
        tree.root.right = tree.new TreeNode(5); 
        tree.root.left.left = tree.new TreeNode(4); 
        tree.root.left.right = tree.new TreeNode(5); 
        //tree.root.right.left = tree.new TreeNode(6); 
        tree.root.right.right = tree.new TreeNode(7);
  
        //System.out.println("Preorder traversal of binary tree is "); 
        //tree.printPreorder(); 
  
        //System.out.println("\nInorder traversal of binary tree is "); 
        //System.out.println("SUM:");
        //System.out.println(tree.printInorder()); 
  
        //System.out.println("\nPostorder traversal of binary tree is "); 
        //tree.printPostorder(); 
        
        //System.out.println("Level order traversal (BFS) of binary tree is "); 
        
        //tree.flattenIN(tree.root);
        tree.connect(root);
    } 
}
