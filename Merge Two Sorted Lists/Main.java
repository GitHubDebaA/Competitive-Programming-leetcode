// Merge Two Sorted Lists; complete: y
// date: 05.12.2021
class Main {
    public static void main(String[] args) {
        int val1[] = {1};
        int val2[] = {};

        ListNode list1, list2;
        list1 = creat(val1);
        list2 = creat(val2);
        display(list1);      
        display(list2);      

        list1 = mergeTwoLists(list1, list2);
        display(list1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeList = null, mp = null, NN;

        ListNode p1 = list1, p2 = list2;

        while(p1 != null && p2 != null) {
            if(p1.val == p2.val) {
                NN = new ListNode(p1.val);
                if(mergeList == null) {
                    mergeList = NN;
                    mp = NN;
                }
                else {
                    mp.next = NN;
                    mp = mp.next;
                }
                p1 = p1.next;

                NN = new ListNode(p2.val);
                if(mergeList == null) {
                    mergeList = NN;
                    mp = NN;
                }
                else {
                    mp.next = NN;
                    mp = mp.next;
                }
                p2 = p2.next;
            }

            else if(p1.val > p2.val) {
                while(p2 != null && p1.val > p2.val) {
                    NN = new ListNode(p2.val);
                    if(mergeList == null) {
                        mergeList = NN;
                        mp = NN;
                    }
                    else {
                        mp.next = NN;
                        mp = mp.next;
                    }
                    p2 = p2.next;
                }
            }   
            else {
                while(p1 != null && p1.val < p2.val) {
                    NN = new ListNode(p1.val);
                    if(mergeList == null) {
                        mergeList = NN;
                        mp = NN;
                    }
                    else {
                        mp.next = NN;
                        mp = mp.next;
                    }
                    p1 = p1.next;
                }
            }
        }

        // display(mergeList);
        if(p1 != null) {
            if(mergeList == null) mergeList = p1;
            else mp.next = p1;            

            while(p1 != null) {
                p1 = p1.next;
            }
        }


        if(p2 != null) {
            if(mergeList == null && p2 != null) mergeList = p2;
            else mp.next = p2;

            while(p2 != null) {
                p2 = p2.next;
            }            
        }

        return mergeList;
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