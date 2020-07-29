package 树.简单;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */


import 树.TreeNode;

/**
 * 注意： 题中为二叉搜索树， 二叉搜索树特点为 树中任一节点 一定符合如下规范： 左子节点 < 根节点 < 右子节点
 * 与题无关的多嘴： 二叉搜索树的中序遍历一定是升序排列， 该树可以用做 查多写少的二分查找（毕竟树的插入很麻烦）
 * <p>
 * 解题思路：
 * 1. 给定 节点 p,q. 如果 p q< root , 则取 root.left为 根节点。 如果p <= root <= q,则root = 根节点,如果 root < p q , 则取root.right 为根节点。
 * 2. 重复上述动作，直到找到公共祖先 或者root = null
 */

public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if ((p.val <= root.val && q.val >=root.val) || (p.val >= root.val && q.val <=root.val) ) {
                result = root;
                break;
            } else {
                break;
            }
        }
        return  result;


    }

}
