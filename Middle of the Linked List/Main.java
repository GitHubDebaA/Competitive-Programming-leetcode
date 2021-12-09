// Middle of the Linked List; complete: y
// date: 05.12.2021

class Main {
    public static void main(String[] args) {
        int val1[] = {};
        int val = 4;
        ListNode head, node;
        head = creat(val1);
        node = search(head, val);
        display(head);    
        node = middleNode(head);
        display(node); 
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