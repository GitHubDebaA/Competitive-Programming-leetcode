// Swap Nodes in Pairs; complete: y
// date: 02.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {};
		int k = 4;
		ListNode head;
		head = creat(val);
		display(head);
		
		head = swapPairs(head);
		display(head);
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode p = head, p1 = null, p2 = null, pp = null;

        while(p != null) {
        	p1 = p;
        	if(p.next != null) {
        		p = p.next;
        		p2 = p;

	        	p = p.next;

        		if(pp == null) {
					p1.next = p2.next;
					p2.next = p1;
					head = p2; 			
        		}
        		else {
					p1.next = p2.next;
					p2.next = p1;
					pp.next = p2;
        		}

        		pp = p1;
        	}
        }
        return head;
    }

	public static ListNode creat(int val[]) {
 		ListNode p = null;
 		ListNode head = null;
 		for(int i=0; i<val.length; i++) {
	 		ListNode NN = new ListNode(val[i], null);
 			if(p == null) {
 				head = NN;
 				p = head;
 			}
 			else {
 				p.next = NN;
 				p = p.next;
 			}
 		}
 		return head;
 	}

 	public static void display(ListNode head) {
 		ListNode p = head;
 		if(p == null) {
 			System.out.println("Linked List is null");
 			return;	
 		}
 		else {
 			while (p != null) {
 				System.out.print(p.val + " ");
 				p = p.next;
 			}
 		}
 		System.out.println();
 	}
}

class ListNode {
 	int val;
 	ListNode next;
 	ListNode() {}
 	ListNode(int val) { this.val = val; }
 	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}