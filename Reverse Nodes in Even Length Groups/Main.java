// Reverse Nodes in Even Length Groups; complete: n
// date: 04.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {1, 2, 3, 4, 5};

		ListNode head;
		head = creat(val);
		display(head);		

		head = reverseEvenLengthGroups(head);
		display(head);
	}

	public static ListNode reverseEvenLengthGroups(ListNode head) {
		ListNode list = head, listend = null, listp = null, p = head, pp = null;

        if(p == null) return head;

        int i=0, flag = 0, k = 1;

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

        	if(k % 2 == 0) list = reverseList(list);

        	display(list);

			if(listp == null) head = list;
	        else listp.next = list;
			listp = listend;        		
			k += 1;
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