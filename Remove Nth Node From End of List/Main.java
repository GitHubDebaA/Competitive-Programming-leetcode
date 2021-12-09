// Remove Nth Node From End of List; complete: y
// date: 02.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {1};
		int n = 1;
		ListNode head;
		head = creat(val);
		display(head);
		head = removeNthFromEnd(head, n);
		display(head);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode mainP = head, tempP = null, mainPP = null, tempPP = null;

		int i = 0;
		if(head == null) return head;
		tempP = head;
		while(i < n) {
			if(tempP == null) {
				return head;
			}
			tempP = tempP.next;
			i += 1;
		}

		if(tempP == null) {
			head = head.next;
			return head;
		}
		else {
			while(tempP != null) {
				mainPP = mainP;
				mainP = mainP.next;
				tempP = tempP.next;
			}
		}

		mainPP.next = mainP.next;
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