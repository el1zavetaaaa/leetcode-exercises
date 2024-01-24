package yl.lbnts.leetcode.algorithm;

public class LinkedListCycle {
    public static void main(String[] args) {
        final ListNode listNode4 = new ListNode(-4, null);
        final ListNode listNode3 = new ListNode(0, listNode4);
        final ListNode listNode2 = new ListNode(2, listNode3);
        final ListNode listNode1 = new ListNode(3, listNode2);

        final ListNode listNode22 = new ListNode(2, null);
        final ListNode listNode21 = new ListNode(1, listNode22);

        final ListNode listNode31 = new ListNode(1, null);

        listNode4.setNext(listNode2);
        listNode22.setNext(listNode21);

        System.out.println(hasCycle(listNode1));
        System.out.println(hasCycle(listNode21));
        System.out.println(hasCycle(listNode31));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow.equals(fast)){
                return true;
            }
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode y) {
            val = x;
            next = y;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
