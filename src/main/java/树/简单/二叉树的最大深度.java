package 树.简单;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */


import 树.TreeNode;

/**
 * 解题思路:
 * 前序遍历，找到子叶节点的深度， 取最大值
 */

public class 二叉树的最大深度 {

    Integer maxDepth = 0;

    public int maxDepth(TreeNode root) {

        pre(root,0);
        return maxDepth;
    }


    public void pre(TreeNode treeNode,Integer depth){
        if (treeNode == null){
            if (maxDepth == 0){
                maxDepth = depth;
            } else {
                maxDepth = Math.max(maxDepth,depth);
            }
            return;
        }
        pre(treeNode.left,depth+1);
        pre(treeNode.right,depth+1);

    }
}
