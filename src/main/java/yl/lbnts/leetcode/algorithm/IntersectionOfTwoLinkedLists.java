package yl.lbnts.leetcode.algorithm;

import java.util.Optional;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNodeInterSec listNodeInterSecAB5 = new ListNodeInterSec(5, null);
        ListNodeInterSec listNodeInterSecAB4 = new ListNodeInterSec(4, listNodeInterSecAB5);

        ListNodeInterSec listNodeInterSecA3 = new ListNodeInterSec(8, listNodeInterSecAB4);
        ListNodeInterSec listNodeInterSecA2 = new ListNodeInterSec(1, listNodeInterSecA3);
        ListNodeInterSec listNodeInterSecA1 = new ListNodeInterSec(4, listNodeInterSecA2);

        ListNodeInterSec listNodeInterSecB4 = new ListNodeInterSec(8, listNodeInterSecAB4);
        ListNodeInterSec listNodeInterSecB3 = new ListNodeInterSec(1, listNodeInterSecB4);
        ListNodeInterSec listNodeInterSecB2 = new ListNodeInterSec(6, listNodeInterSecB3);
        ListNodeInterSec listNodeInterSecB1 = new ListNodeInterSec(5, listNodeInterSecB2);

        ListNodeInterSec listNodeInterSecAB1 = new ListNodeInterSec(1, null);

        System.out.println("---------EXAMPLE 1-----------");
        System.out.println("Intersection: 8, Array1: [4,1,8,4,5] Array2: [5,6,1,8,4,5], Skip1: 2, Skip2: 3.");

        System.out.println(getIntersectionNode(listNodeInterSecA1, listNodeInterSecB1).toString());
        System.out.println(listNodeInterSecA1);

        System.out.println("\n---------EXAMPLE 2-----------");
        System.out.println("Intersection: 1, Array1: [1], Array2: [1], Skip1: 0, Skip2: 0.");

        System.out.println(getIntersectionNode(listNodeInterSecAB1, listNodeInterSecAB1).toString());
        System.out.println(listNodeInterSecAB1);

    }

    public static ListNodeInterSec getIntersectionNode(ListNodeInterSec headA, ListNodeInterSec headB) {

        int arrLengthHeadA = calculateArrayLength(headA);
        int[] arrHeadA = createArrayOfValues(headA, arrLengthHeadA);
        ListNodeInterSec[] arrLinksHeadA = createArrOfLinks(headA, arrLengthHeadA);
        ListNodeInterSec[] arrListNodesHeadA = createArrOfListNodes(headA, arrLengthHeadA);

        int arrLengthHeadB = calculateArrayLength(headB);
        int[] arrHeadB = createArrayOfValues(headB, arrLengthHeadB);
        ListNodeInterSec[] arrLinksHeadB = createArrOfLinks(headB, arrLengthHeadB);
        ListNodeInterSec[] arrListNodesHeadB = createArrOfListNodes(headB, arrLengthHeadB);

        int intersectVal = findArraysIntersection(arrHeadA, arrHeadB, arrLinksHeadA, arrLinksHeadB, arrListNodesHeadA, arrListNodesHeadB);

        return findIntersecNode(headA, intersectVal);

    }

    private static int calculateArrayLength(ListNodeInterSec a) {
        int count = 0;
        while (a != null) {
            count++;
            a = a.next;
        }

        return count;
    }

    private static int[] createArrayOfValues(ListNodeInterSec a, int arrLength) {
        int count = 0;
        int[] arr = new int[arrLength];

        while (a != null) {
            arr[count] = a.val;
            count++;
            a = a.next;
        }

        return arr;
    }

    private static ListNodeInterSec[] createArrOfLinks(ListNodeInterSec head, int arrLength) {
        int count = 0;
        ListNodeInterSec[] arr = new ListNodeInterSec[arrLength];

        while (head.next != null) {
            arr[count] = head.next;
            count++;
            head = head.next;
        }

        return arr;
    }

    private static ListNodeInterSec[] createArrOfListNodes(ListNodeInterSec head, int arrLength) {
        int count = 0;
        ListNodeInterSec[] arr = new ListNodeInterSec[arrLength];

        while (head != null) {
            arr[count] = head;
            count++;
            head = head.next;
        }

        return arr;
    }

    private static int findArraysIntersection(int[] arrA, int[] arrB, ListNodeInterSec[] arrLinksA, ListNodeInterSec[] arrLinksB,
                                              ListNodeInterSec[] arrListNodesA, ListNodeInterSec[] arrListNodesB) {
        for (int i = 0; i < arrA.length; i++) {
            for (int k = 0; k < arrB.length; k++) {
                if (arrA[i] == arrB[k]) {
                    if (Optional.ofNullable(arrLinksA[i]).equals(Optional.ofNullable(arrLinksB[k]))) {
                        if (arrListNodesA[i].equals(arrListNodesB[k])) {
                            return arrA[i];
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static ListNodeInterSec findIntersecNode(ListNodeInterSec head, int valIntersec) {

        while (head != null) {
            int currentVal = head.val;

            if (currentVal == valIntersec) {
                return head;
            }

            head = head.next;
        }

        return null;
    }
}

class ListNodeInterSec {
    int val;
    ListNodeInterSec next;

    ListNodeInterSec(int x, ListNodeInterSec next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNodeInterSec{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
