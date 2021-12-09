// Swapping Nodes in a Linked List; complete: y
// date: 02.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int val[] = {1, 2, 3, 4, 5};
		int k = 4;
		ListNode head;
		head = creat(val);
		display(head);
		
		head = swapNodes(head, k);
		display(head);
	}

    public static ListNode swapNodes(ListNode head, int k) {
		ListNode mainP = head, tempP = null, endP = null, tempPP = null;

		int i = 0;
		if(head == null) return head;
		tempP = head;
		while(i < k) {
			if(tempP == null) {
				return head;
			}
			tempPP = tempP;
			tempP = tempP.next;
			i += 1;
		}

		if(tempP == null) {
			int temp = tempPP.val;
			tempPP.val = mainP.val;
			mainP.val = temp;
		}
		else {
			mainP = tempPP;
			endP = head;
			while(tempP != null) {
				endP = endP.next;
				tempP = tempP.next;
			}

			int temp = endP.val;
			endP.val = mainP.val;
			mainP.val = temp;
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