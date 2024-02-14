package yl.lbnts.leetcode.algorithm;

import java.util.*;

public class IsThisABinaryTree {

    public static void main(String[] args) {
        Node node5 = new Node(1, null, null);
        Node node6 = new Node(6, null, null);
        Node node4 = new Node(5, node6, node5);
        Node node3  = new Node(1, null, null);
        Node node2 = new Node(2, node3, null);
        Node node1 = new Node(3, node2, node4);

        Node node62 = new Node(10, null, null);
        Node node52 = new Node(6, null, null);
        Node node42 = new Node(8, node52, node62);
        Node node32 = new Node(2, null, null);
        Node node22 = new Node(5, node32, null);
        Node node12 = new Node(7, node22, node42);

        System.out.println(checkBST(node1));
        System.out.println(checkBST(node12));

    }

    private static boolean checkBST(Node root) {
        List<Integer> nodes = new ArrayList<>();

        return checkBST(root, nodes);

    }

    private static boolean checkBST(Node root, List<Integer> nodes){
        if(root == null){
            return true;
        }
        if( root.left != null && root.right!=null &&
                root.data <= root.left.data && root.data >= root.right.data){
            return false;
        }

        nodes.add(root.data);
        return checkPlagiats(nodes) && checkBST(root.left, nodes) && checkBST(root.right, nodes);
    }

    private static boolean checkPlagiats(List<Integer> nodes){
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i+1; j < nodes.size(); j++) {
                if(Objects.equals(nodes.get(i), nodes.get(j))){
                    return false;
                }
            }
        }

        return true;
    }

}

    class Node {
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int data;
        Node left;

        Node right;
    }

