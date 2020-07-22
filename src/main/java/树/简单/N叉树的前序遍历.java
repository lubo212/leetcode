package 树.简单;
/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */

import 树.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 解题思路：
 * 递归解法不解释，很简单
 *
 * 非递归解法：
 * 非递归需要一个栈做辅助
 * 1. root节点入栈
 * 2. pop栈中节点，打印该节点的值。逆序取出该节点所有子节点放入栈中
 * 3. 重复2操作，直到栈为空
 */

public class N叉树的前序遍历 {

    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        preOrderTraverse2(root, resultList);
        return resultList;
    }


    /**
     * 递归解法
     *
     * @param root
     * @param result
     */
    public void preOrderTraverse1(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        List<Node> children = root.children;
        if (children != null) {
            for (Node node : children) {
                preOrderTraverse1(node, result);
            }
        }
    }

    /**
     * 非递归解法
     *
     * @param root
     * @param result
     */
    public void preOrderTraverse2(Node root, List<Integer> result) {
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node == null){
                continue;
            }
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
    }

}
