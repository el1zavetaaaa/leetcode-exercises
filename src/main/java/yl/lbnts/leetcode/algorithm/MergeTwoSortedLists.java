package yl.lbnts.leetcode.algorithm;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNodeMergeTwoSortedLists listNodeMergeTwoSortedLists3 = new ListNodeMergeTwoSortedLists(4);
        ListNodeMergeTwoSortedLists listNodeMergeTwoSortedLists2 = new ListNodeMergeTwoSortedLists(2, listNodeMergeTwoSortedLists3);
        ListNodeMergeTwoSortedLists listNodeMergeTwoSortedLists1 = new ListNodeMergeTwoSortedLists(1, listNodeMergeTwoSortedLists2);

        ListNodeMergeTwoSortedLists listNodeMergeTwoSortedLists33 = new ListNodeMergeTwoSortedLists(4);
        ListNodeMergeTwoSortedLists listNodeMergeTwoSortedLists32 = new ListNodeMergeTwoSortedLists(3, listNodeMergeTwoSortedLists33);
        ListNodeMergeTwoSortedLists listNodeMergeTwoSortedLists31 = new ListNodeMergeTwoSortedLists(1, listNodeMergeTwoSortedLists32);

        System.out.println(mergeTwoLists(listNodeMergeTwoSortedLists1, listNodeMergeTwoSortedLists31));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNodeMergeTwoSortedLists {
     * int val;
     * ListNodeMergeTwoSortedLists next;
     * ListNodeMergeTwoSortedLists() {}
     * ListNodeMergeTwoSortedLists(int val) { this.val = val; }
     * ListNodeMergeTwoSortedLists(int val, ListNodeMergeTwoSortedLists next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNodeMergeTwoSortedLists mergeTwoLists(ListNodeMergeTwoSortedLists list1, ListNodeMergeTwoSortedLists list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }
}

class ListNodeMergeTwoSortedLists {
    int val;
    ListNodeMergeTwoSortedLists next;

    ListNodeMergeTwoSortedLists() {
    }

    ListNodeMergeTwoSortedLists(int val) {
        this.val = val;
    }

    ListNodeMergeTwoSortedLists(int val, ListNodeMergeTwoSortedLists next) {
        this.val = val;
        this.next = next;
    }
}
