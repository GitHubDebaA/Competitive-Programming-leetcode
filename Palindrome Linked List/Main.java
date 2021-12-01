// Palindrome Linked List; complete: y
// date: 30.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {1,2,3,4,5};
		ListNode head;
		head = creat(val);
		display(head);

		// head = reverseList(head);
		// display(head);

		head = reverseBetween(head, 1, 5);
		display(head);
	}

    public static ListNode reverseBetween(ListNode head, int left, int right) {
    	int counter = 1;
    	ListNode pre = head, preend = null, post = null, list = null, listend = null;

    	if(head == null) return head;
    	if(head.next == null) return head;

    	ListNode p = head, pp = null, np = p.next;

    	while(p != null) {
    		System.out.println("val: "+p.val+"\tnext: "+p.next);
    		if(counter == left) {
    			list = p;
    			preend = pp;
 				listend = p;
    		}

    		if(counter == right) {
    			post = p.next;
    			p.next = null;
    		}

    		counter += 1;
    		pp = p;
    		p = np;
    		if(np != null) np = np.next;
    	}

    	list = reverseList(list);
    	if(preend == null) head = list;
    	else preend.next = list;

    	listend.next = post;

    	return head;
    }

	public boolean isPalindrome(ListNode head) {
    	List<Integer> list = new ArrayList<> ();

    	ListNode p = head;

    	while(p != null) {
    		list.add(p.val);
    		p = p.next;
    	}    

    	int i = 0, j = list.size()-1;

    	while(i < j) {
    		if(list.get(i) != list.get(j)) return false;

    		i += 1;
    		j -= 1;
    	}

    	return true;
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