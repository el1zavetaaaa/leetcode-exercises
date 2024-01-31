package yl.lbnts.leetcode.interview;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TreeSetTest {

    @Test
    public void testTreeSet(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(10);
        treeSet.add(7);

        System.out.println(treeSet);
    }
}
