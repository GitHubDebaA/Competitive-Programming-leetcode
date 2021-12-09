// Remove Duplicates from Sorted List II; complete: n
// date: 05.12.2021

class Main {
    public static void main(String[] args) {
        int val1[] = {1};
        int val = 1;
        ListNode head, node;
        head = creat(val1);
        node = search(head, val);
        display(head);

        head = rotateRight(head, val);
        display(head);
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head, p2 = head, pp = null;
        while(p1 != null) {
        	p2 = p1;
        	while(p2 != null && p1.val == p2.val) p2 = p2.next;
        	if(pp == null) {
        		if(p2 == null) {
        			head = p2;
        			p1 = p2;
        		}
        		else {
        			head = p2.next;
					pp = head;
					p1 = p2.next;
        		}        		
        	}
        	else {

        	}
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

    public static ListNode middleNode(ListNode head) {
        ListNode p = head;
        int len = 0;
        while(p != null) {
            len += 1;
            p = p.next;
        }

        int mid = len / 2;
        p = head;
        for(int i=0; i<mid; i++) {
            p = p.next;
        }

        return p;
    }

    public static void deleteNode(ListNode node) {
        ListNode pp = node, p = node.next;
        while(p != null) {
        	pp.val = p.val;
        	if(p.next != null) pp = p;
        	p = p.next;
        }
        pp.next = null;
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

    public static ListNode search(ListNode head, int val) {
    	ListNode p = head;

    	while (p != null) {
    		if(p.val == val) return p;
    		p = p.next;
    	}
    	return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}