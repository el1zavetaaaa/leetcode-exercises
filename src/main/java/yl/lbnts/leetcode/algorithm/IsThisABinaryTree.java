package yl.lbnts.leetcode.algorithm;

import java.util.*;

public class IsThisABinaryTree {

    public static void main(String[] args) {
        IsBinaryTreeNode isBinaryTreeNode5 = new IsBinaryTreeNode(1, null, null);
        IsBinaryTreeNode isBinaryTreeNode6 = new IsBinaryTreeNode(6, null, null);
        IsBinaryTreeNode isBinaryTreeNode4 = new IsBinaryTreeNode(5, isBinaryTreeNode6, isBinaryTreeNode5);
        IsBinaryTreeNode isBinaryTreeNode3 = new IsBinaryTreeNode(1, null, null);
        IsBinaryTreeNode isBinaryTreeNode2 = new IsBinaryTreeNode(2, isBinaryTreeNode3, null);
        IsBinaryTreeNode isBinaryTreeNode1 = new IsBinaryTreeNode(3, isBinaryTreeNode2, isBinaryTreeNode4);

        IsBinaryTreeNode isBinaryTreeNode62 = new IsBinaryTreeNode(10, null, null);
        IsBinaryTreeNode isBinaryTreeNode52 = new IsBinaryTreeNode(6, null, null);
        IsBinaryTreeNode isBinaryTreeNode42 = new IsBinaryTreeNode(8, isBinaryTreeNode52, isBinaryTreeNode62);
        IsBinaryTreeNode isBinaryTreeNode32 = new IsBinaryTreeNode(2, null, null);
        IsBinaryTreeNode isBinaryTreeNode22 = new IsBinaryTreeNode(5, isBinaryTreeNode32, null);
        IsBinaryTreeNode isBinaryTreeNode12 = new IsBinaryTreeNode(7, isBinaryTreeNode22, isBinaryTreeNode42);

        System.out.println(checkBST(isBinaryTreeNode1));
        System.out.println(checkBST(isBinaryTreeNode12));

    }

    private static boolean checkBST(IsBinaryTreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        return checkBST(root, nodes);

    }

    private static boolean checkBST(IsBinaryTreeNode root, List<Integer> nodes){
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

    class IsBinaryTreeNode {
        public IsBinaryTreeNode(int data, IsBinaryTreeNode left, IsBinaryTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int data;
        IsBinaryTreeNode left;

        IsBinaryTreeNode right;
    }

