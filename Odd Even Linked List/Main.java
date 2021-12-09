// Odd Even Linked List; complete: n
// date: 02.12.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {1, 2};
		ListNode head;
		head = creat(val);

		head = oddEvenList(head);
		display(head);
	}

	public static ListNode oddEvenList(ListNode head) {
		ListNode evenList = null, oddList = null, p = head, evenListP = null, oddListP = null;

		int i = 1;
		if(p == null) return head;
		while(p != null) {
			if(i % 2 == 0) {

				if(evenList == null) {					
					evenList = p;
					evenListP = p;
					p = p.next;
					evenList.next = null;
				}
				else {
					evenListP.next = p;
					evenListP = evenListP.next;
					p = p.next;
					evenListP.next = null;
				}
			}
			else {
				if(oddList == null) {
					oddList = p;
					oddListP = p;
					p = p.next;
					oddList.next = null;
				}
				else {
					oddListP.next = p;
					oddListP = oddListP.next;
					p = p.next;
					oddListP.next = null;
				}
			}

			i += 1;
		}

		oddListP.next = evenList;

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