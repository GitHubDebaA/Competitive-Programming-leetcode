// Remove Linked List Elements; complete: y
// date: 05.12.2021

class Main {
    public static void main(String[] args) {
        int val1[] = {1,1,1,1};
        int val = 1;
        ListNode list1;
        list1 = creat(val1);
        display(list1);      


        list1 = removeElements(list1, val);
        display(list1);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode p = head, pp = null;
        while(p != null) {
        	if(p.val == val) {
        		if(pp == null) head = p.next;
        		else pp.next = p.next;
        	}
        	else pp = p;
        	p = p.next;
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