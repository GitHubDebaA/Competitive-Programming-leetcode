// Reverse Nodes in k-Group; complete: y
// date: 03.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {1, 2, 3, 4, 5, 6};
		int k = 2;
		ListNode head;
		head = creat(val);
		display(head);
		
		head = reverseKGroup(head, k);
		display(head);
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode list = head, listend = null, listp = null, p = head, pp = null;

        if(p == null) return head;
        if(k == 1) return head;

        int i=0, flag = 0;

        while(true) {
        	list = p;
        	i = 0;
        	while(i < k) {
        		if(p == null) {
		        	if(listp == null) head = list;
        			else listp.next = list;        			
        			return head;
        		}
	        	pp = p;
    	    	p = p.next;
        		i += 1;
        	}
        	listend = pp;
        	listend.next = null;
        	listend = list;
        	list = reverseList(list);

        	if(listp == null) head = list;
        	else listp.next = list;

        	listp = listend;
	        }
    }

	public static ListNode reverseList(ListNode head) {
    	ListNode p = head;
    	ListNode pp;
    	ListNode np;
    	
    	if(p == null) return p;
    	if(p.next == null) return p;

    	pp = null;
    	np = p.next;
    	while(p != null) {
    		p.next = pp;
    		pp = p;
    		p = np;

    		if(np != null) {
    			np = np.next;
    		}
    	}
    	head = pp;
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