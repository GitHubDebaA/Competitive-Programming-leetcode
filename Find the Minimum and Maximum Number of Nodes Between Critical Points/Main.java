// Find the Minimum and Maximum Number of Nodes Between Critical Points; complete: y
// date: 05.11.2021

import java.util.*;

class Main {
	public static void main(String[] args) {
		int A[] = {1,2,2,2,3,2,2,2,7}; //output: 3,3
		ListNode head = new ListNode(A);
		// head = head.creat(A);

		ListNode ptr = head;
		while(ptr != null) {
			System.out.print(ptr.val+", ");
			ptr = ptr.next;
		}
		System.out.println();
		System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
	}

	public static int[] nodesBetweenCriticalPoints(ListNode head) {
		ListNode pp = null, p = head, np = null;
		int A[] = {-1, -1};
		List<Integer> aList = new ArrayList<Integer> ();
		if(p == null) return A;
		np = p.next;
		int i = 1;
		pp = p;
		p = p.next;
		np = p.next;
		i += 1;

		if(p.next == null) return A;
		while(p.next != null) {
			System.out.print("value: "+p.val+"\tP value: "+pp.val+"\tN value: "+np.val);
			if((pp.val > p.val && np.val > p.val) || (pp.val < p.val && np.val < p.val)) {
				System.out.println("\tCritical Point");
				aList.add(i);
			}
			else System.out.println("\tNot Critical Point");
			pp = p;
			p = p.next;
			np = p.next;
			i += 1;	
		}

		System.out.println(aList);
		if(aList.size() < 2) return A;
		A[1] = aList.get(aList.size()-1) - aList.get(0);
		int min = Integer.MAX_VALUE;
		for(i=1; i<aList.size(); i++) {
			if(aList.get(i) - aList.get(i-1) < min) {
				min = aList.get(i) - aList.get(i-1);
			}
			if(min == 1) break;
		}
		A[0] = min;
		return A;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	ListNode(int values[]) {
		ListNode head = creat(values);
		this.val = head.val;
		this.next = head.next;
	}

	ListNode creat(int values[]) {
		ListNode head = new ListNode();
		ListNode ptr = head;

		for(int i=0; i<values.length; i++) {
			ListNode nn = new ListNode(values[i], null);
			if(i == 0) {
				head = nn;
				ptr = head;
			}
			else {
				ptr.next = nn;
				ptr = nn;
			}
		}
		return head;
	}
}