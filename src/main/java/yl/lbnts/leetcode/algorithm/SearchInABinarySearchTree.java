package yl.lbnts.leetcode.algorithm;

public class SearchInABinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val =4;

        TreeNode treeNodeL1 = new TreeNode();
        treeNodeL1.val = 2;
        treeNode.left = treeNodeL1;

        TreeNode treeNodeR1 = new TreeNode();
        treeNodeR1.val =7;
        treeNode.right = treeNodeR1;

        TreeNode treeNodeL2 = new TreeNode();
        treeNodeL2.val = 1;
        treeNodeL1.left = treeNodeL2;

        TreeNode treeNodeLR1 = new TreeNode();
        treeNodeLR1.val =3;
        treeNodeL1.right=treeNodeLR1;

        System.out.println(searchBST(treeNode, 2));
    }
    private static TreeNode searchBST(TreeNode root, int val) {
        TreeNode currentNode = root;

        if(currentNode == null){
            return null;
        }

          while (currentNode.val != val) {
              if (val < root.val) {
                  currentNode = currentNode.left;
              } else {
                  currentNode = currentNode.right;
              }
          }

        return currentNode;
    }

    private static TreeNode recursiveSearch(TreeNode root, int val ){
        if (root == null) return root;
        if (val < root.val) return recursiveSearch(root.left, val);
        if (val > root.val) return recursiveSearch(root.right, val);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
