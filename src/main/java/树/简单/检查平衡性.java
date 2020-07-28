package 树.简单;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * https://leetcode-cn.com/problems/check-balance-lcci/
 */


import 树.TreeNode;

/**
 * 解题思路：
 * 1. 前序优先遍历，获取叶子节点的最小和最大深度，如果深度相差大于1，则不平衡
 * 2.  如果发现不平衡的节点，则不需要再往下递归，直接返回-1即可
 */

public class 检查平衡性 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        treeNode.left.left.right = new TreeNode(9);
        treeNode.left.right.left = new TreeNode(10);
        treeNode.left.right.right = new TreeNode(11);
        treeNode.right.left.left = new TreeNode(12);
        treeNode.right.left.right = new TreeNode( 13);
        treeNode.left.left.left.left = new TreeNode(14);
        treeNode.left.left.left.right = new TreeNode(15);
        检查平衡性 test = new 检查平衡性();
        boolean balanced = test.isBalanced(treeNode);
        System.out.println(balanced);
    }


    Boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depth = 0;
        preOrderTraverse1(root, depth);
        if (!isBalance) {
            return false;
        }
        return true;

    }


    private Integer preOrderTraverse1(TreeNode node, Integer depth) {
        if (!isBalance) {
            return -1;
        }
        if (node == null) {
            return depth;
        }
        Integer leftDepth = preOrderTraverse1(node.left, depth+1);
        Integer rightDepth = preOrderTraverse1(node.right, depth+1);
        System.out.println(leftDepth + "," + rightDepth + "," + Math.abs(leftDepth - rightDepth));
        if (isBalance && Math.abs(leftDepth - rightDepth) > 1){
            isBalance = false;
        }
        return Math.max(leftDepth,rightDepth);
    }


}
