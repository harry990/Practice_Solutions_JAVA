import java.util.ArrayList;
import java.util.HashMap;

/*
 * rotateRight *
Ex: {1,2,3} k=2 Move the list after the 1st node to the front

Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.

So the code has three parts.

Get the length

Move to the (l-n%l)th node

3)Do the rotation
*/
public class manipulateLinkedList {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	//  rotate linkedlist
	public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null||k==0) return head;
        
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode fast=node,slow=node;
        
        //get length
        int n;
        for(n=0;fast.next!=null;n++) fast=fast.next;
        //get (n-k%n)th node
        for(int i=n-k%n;i>0;i--) slow = slow.next;
        
        //Rotate
        fast.next=node.next;
        node.next=slow.next;
        slow.next=null;
        
        return node.next;
    }
	// 206. reverse linkedlist
	public ListNode reverseList(ListNode head) {
	    ListNode prev = null;
	    ListNode curr = head;
	    while (curr != null) {
	        ListNode nextTemp = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = nextTemp;
	    }
	    return prev;
	    
	    /*
	     RECURSIVE
	     if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	     */
	}
	// 92. Reverse a linked list from position m to n. Do it in one-pass.
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		 if (head==null || head.next==null||m==n) return head;
		 
		 ListNode node = new ListNode(-1);
		 node.next = head;
		 ListNode p = node;
		 
		 // reach till m
		 for(int i =0;i<m-1;i++) p = p.next;
		 ListNode tail = p.next;
		 ListNode temp = tail.next;
		 
		 for(int i=0;i<n-m;i++) {
			 tail.next = temp.next;
			 temp.next=p.next;
			 p.next = temp;
			 temp=tail.next;
		 }
		 
		 return node.next;
	 }
	 
	 /**
	  * Definition for singly-linked list with a random pointer.
	  */
	 public class RandomListNode {
	     int label;
	     RandomListNode next, random;
	     RandomListNode(int x) { this.label = x; }
	 }
	 //deep copy of only the non-random list
	 public RandomListNode copyNonRandomList(RandomListNode head) {
         if(head==null) return null;
         
         //RandomListNode dummy = new RandomListNode(-1);
         RandomListNode res = new RandomListNode(99);
         RandomListNode prev = null;
         RandomListNode out = new RandomListNode(99);
         
         res = new RandomListNode(head.label);
         out.next=res;
         prev = res;
         res = res.next;
         head=head.next;
         while(head!=null){
        	 res = new RandomListNode(head.label);
             //res.random = null;
             if (prev!=null) prev.next = res;
             prev = res;
             res = res.next;
             head=head.next;
         }
         return out.next;
     }
	 //deep copy of random list
	 public RandomListNode copyRandomList(RandomListNode head) {
         if(head==null) return null;
        
        RandomListNode dummy = head;
        
        //place original list next to copy list
        // If A->B->C is the original linked list,
        // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
        while(dummy!=null) {
        	RandomListNode temp = new RandomListNode(dummy.label);
        	temp.next=dummy.next;
        	dummy.next=temp;
        	dummy=temp.next;
        }
        
        dummy=head;
        //put random pointers in place
        while(dummy!=null) {
        	dummy.next.random = (dummy.random!=null)?dummy.random.next:null;
        	dummy = dummy.next.next;
        }
        
        //unweave 
        RandomListNode old = head;
        RandomListNode curr = head.next;
        RandomListNode out = head.next;
        while(old!=null) {
        	old.next = old.next.next;
        	old.next = (curr.next != null) ? curr.next.next:null;
        	old = old.next;
        	curr = curr.next;
        }
        
        return out;
         
         /*
         // dummy and copy relation
         HashMap<RandomListNode, RandomListNode> hm =
        	      new HashMap<RandomListNode, RandomListNode>();
         // random nodes list which are in future
         HashMap<RandomListNode, ArrayList<RandomListNode>> rl =
       	      new HashMap<RandomListNode, ArrayList<RandomListNode>>();
         
         RandomListNode dummy = new RandomListNode(-1);
         RandomListNode res = new RandomListNode(99);
         RandomListNode prev = null;
         RandomListNode out = new RandomListNode(99);
         
         dummy = head;
         
         res = new RandomListNode(head.label);
         out.next=res;
         hm.put(dummy,res);
         if (hm.containsKey(dummy.random))
        	 res.random = hm.get(dummy.random);
         else {
        	 ArrayList<RandomListNode> temp = new ArrayList<RandomListNode>();
        	 temp.add(dummy);
             rl.put(dummy.random,temp); //add so that one can refer back
         }
         prev = res;
         res = res.next;
         dummy=dummy.next;
         while(dummy!=null){
        	 res = new RandomListNode(dummy.label);
             if (prev!=null) prev.next = res;
             prev = res;
             hm.put(dummy,res);
             //check is random has been visited
             if (hm.containsKey(dummy.random))
            	 res.random = hm.get(dummy.random);
             else {
            	 if (rl.containsKey(dummy.random)){
            		 ArrayList<RandomListNode> temp = rl.get(dummy.random);
            		 temp.add(dummy);
            		 rl.replace(dummy.random, temp);
            	 } else {
                	 ArrayList<RandomListNode> temp = new ArrayList<RandomListNode>();
                	 temp.add(dummy);
                     rl.put(dummy.random,temp); //add so that one can refer back
            	 }
             }
             // check if someone pointed to this as random 
             if (rl.containsKey(dummy)){
            	 ArrayList<RandomListNode> temp = rl.get(dummy);
            	 for (RandomListNode t:temp) {
            		 hm.get(t).random = res;
            	 }
            	 rl.remove(dummy); // no need of this now since we have this node in hm
             }
             res = res.next;
             dummy=dummy.next;
         }
         /*
         
         /*
         // dummy and copy relation
         HashMap<RandomListNode, RandomListNode> hm =
        	      new HashMap<RandomListNode, RandomListNode>();
         
         RandomListNode dummy = new RandomListNode(-1);
         RandomListNode res = new RandomListNode(99);
         RandomListNode prev = null;
         RandomListNode out = new RandomListNode(99);
         
         dummy = head;
         
         res = new RandomListNode(head.label);
         out.next=res;
         hm.put(dummy,res);
         if (hm.containsKey(dummy.random))
            res.random = hm.get(dummy.random);
         prev = res;
         res = res.next;
         dummy=dummy.next;
         while(dummy!=null){
        	 res = new RandomListNode(dummy.label);
             if (prev!=null) prev.next = res;
             prev = res;
             hm.put(dummy,res);
             if (hm.containsKey(dummy.random))
            	 res.random = hm.get(dummy.random);
             res = res.next;
             dummy=dummy.next;
         } 
         
         dummy = head;
         RandomListNode temp = out.next;
		 while(dummy!=null){
        	 if (temp.random==null) {
        		 if (hm.containsKey(dummy.random))
        			 temp.random = hm.get(dummy.random);
        	 }
        	 temp = temp.next;
             dummy=dummy.next;
         }
         */
         //return out.next;
     }
	 
	 // reverse and rearrange
	 public void reorderList(ListNode head) {
         if(head==null||head.next==null) return;
         
         //Find the middle of the list
         ListNode p1=head; // slow
         ListNode p2=head; // fast
         while(p2.next!=null&&p2.next.next!=null){ 
             p1=p1.next;
             p2=p2.next.next;
         }
         
         //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
         ListNode preMiddle=p1;
         ListNode preCurrent=p1.next;
         while(preCurrent.next!=null){
             ListNode current=preCurrent.next;
             preCurrent.next=current.next;
             current.next=preMiddle.next;
             preMiddle.next=current;
         }
         
         //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
         p1=head;
         p2=preMiddle.next;
         while(p1!=preMiddle){
             preMiddle.next=p2.next;
             p2.next=p1.next;
             p1.next=p2;
             p1=p2.next;
             p2=preMiddle.next;
         }
     }
	 
	 // merge sort
	 public ListNode sortList(ListNode head) {
		    if (head == null || head.next == null)
		      return head;
		        
		    // step 1. cut the list to two halves
		    ListNode prev = null, slow = head, fast = head;
		    
		    while (fast != null && fast.next != null) {
		      prev = slow;
		      slow = slow.next;
		      fast = fast.next.next;
		    }
		    
		    prev.next = null;
		    
		    // step 2. sort each half
		    ListNode l1 = sortList(head);
		    ListNode l2 = sortList(slow);
		    
		    // step 3. merge l1 and l2
		    return merge(l1, l2);
		  }
		  
		  ListNode merge(ListNode l1, ListNode l2) {
		    ListNode l = new ListNode(0), p = l;
		    // This works too
		    //ListNode p = new ListNode(0),l=p;
		    
		    while (l1 != null && l2 != null) {
		      if (l1.val < l2.val) {
		        p.next = l1;
		        l1 = l1.next;
		      } else {
		        p.next = l2;
		        l2 = l2.next;
		      }
		      p = p.next;
		    }
		    
		    if (l1 != null)
		      p.next = l1;
		    
		    if (l2 != null)
		      p.next = l2;
		    
		    return l.next;
		  }
	 
	 public static void main(String[] args) 
	    { 
		 	manipulateLinkedList test = new manipulateLinkedList(); 
		 	
		 	RandomListNode a1 = test.new RandomListNode(-1);
		 	//RandomListNode a2 = test.new RandomListNode(2);
		 	//RandomListNode a3 = test.new RandomListNode(3);
		    //RandomListNode a4 = test.new RandomListNode(4);
		 	
		 	a1.next=null;
		 	//a2.next=a3;
		 	//a3.next=a4;
		 	//a4.next=null;
		 	
		 	a1.random=a1;
		 	//a2.random=a4;
		 	//a3.random=a4;
		 	//a4.random=a2;
		 	
		 	RandomListNode temp = test.copyRandomList(a1);
	    }
}
