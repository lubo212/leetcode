package 树.简单;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * https://leetcode-cn.com/problems/symmetric-tree/
 */


import 树.Node;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 解题思路：
 *  双指针p q, 遍历节点， p右移时q左移，如果一直相等，则是对称树，否则不是
 */

public class 对称二叉树 {

    Boolean isSym =true;

    public boolean isSymmetric(TreeNode root) {
        isSymmetry(root,root);
        return isSym;
    }


    public void isSymmetry(TreeNode pRoot, TreeNode qRoot) {
        if (!isSym){
            return;
        }
        if (pRoot == null || qRoot == null){
            if (pRoot != null && qRoot == null) {
                isSym = false;
            }
            if (pRoot == null && qRoot != null) {
                isSym = false;
            }
            return;
        }
        if (pRoot.val != qRoot.val){
            isSym = false;
            return;
        }
        isSymmetry(pRoot.left,qRoot.right);
        isSymmetry(pRoot.right,qRoot.left);
    }

}
