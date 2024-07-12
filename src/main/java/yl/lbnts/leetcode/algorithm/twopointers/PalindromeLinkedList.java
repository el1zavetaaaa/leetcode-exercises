package yl.lbnts.leetcode.algorithm.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(1);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode22 = new ListNode(2);
        ListNode listNode21 = new ListNode(1, listNode22);
        System.out.println(isPalindrome(listNode1));
        System.out.println(isPalindrome(listNode21));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode current = head;
        List<Integer> vals = new ArrayList<>();
        while (current != null) {
            vals.add(current.val);
            current = current.next;
        }

        int k = 0;
        int j = vals.size() - 1;

        while (k <= j) {
            if (!Objects.equals(vals.get(k), vals.get(j))) {
                return false;
            }
            k++;
            j--;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
