package yl.lbnts.leetcode.algorithm.binarytreeordertraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        System.out.println(postorderTraversal(treeNode1));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
