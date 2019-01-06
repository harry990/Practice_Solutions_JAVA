import java.util.HashMap;
import java.util.Map;

public class removeDuplicates {
	 // Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 // delete extra from repeated nums from sorted list
	 public ListNode deleteDuplicates1(ListNode head) {
	        if (head == null) return head;
	        
	        ListNode node = head;
	        while(node != null && node.next!=null) {
	        	if (node.val == node.next.val) {
	        		node.next = node.next.next;
	        	} else
	        		node = node.next;
	        }
	        
	        return head;
	 }
	 
	 // delete repeated nums from sorted list and keep unique
	 public ListNode deleteDuplicates2(ListNode head) {
	        if (head == null) return head;
	        
	        ListNode node = head;
	        ListNode pre = null;
	        while(node != null && node.next!=null) {
	        	if (node.val == node.next.val) {
	        		node.next = node.next.next;
	        	} else
	        		node = node.next;
	        }
	        
	        return head;
	 }
	 
	 
	 //[1,2,3,3,4,4,5]
	 public static void main (String[] args) 
     { 
		 removeDuplicates newOb = new removeDuplicates();

		 /*
		 ListNode i1 = newOb.new ListNode(4);
		 i1.next = null;
		 ListNode i2 = newOb.new ListNode(4);
		 i2.next = i1;
		 ListNode i3 = newOb.new ListNode(3);
		 i3.next = i2;
		 ListNode i4 = newOb.new ListNode(3);
		 i4.next = i3;
		 ListNode i5 = newOb.new ListNode(2);
		 i5.next = i4;
		 */
		 ListNode i6 = newOb.new ListNode(1);
		 i6.next = null;
		 ListNode i7 = newOb.new ListNode(1);
		 i7.next = i6;
		 ListNode i8 = newOb.new ListNode(1);
		 i8.next = i7;
		 
		 ListNode l = newOb.deleteDuplicates1(i8);
     }

}
