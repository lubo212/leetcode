package 树.简单;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */


import 树.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 解题思路：
 * 递归比较简单，不考虑
 * 非递归思路：
 * 假设有一棵树
 * 1
 * 2   3
 * 4 5 6 7
 * <p>
 * 其后续遍历结果 = 4526731 ,反转该结果： 1376254 ,观察发现是前序遍历的镜像结果，故而可以思考变种前序遍历来完成后续遍历操作
 * <p>
 * 具体操作步骤：
 * 1. root节点入栈，生成链表对象
 * 2. pop Root节点，存入链表表头，将root节点子节点顺序序入栈。
 * 3. 重复2操作，直到链表为null。 注意所有pop节点均打印至链表表头
 */

public class N叉树的后序遍历 {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        postorder2(root, result);
        return result;
    }


    public void postorder2(Node root, LinkedList<Integer> result) {
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            result.addFirst(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
    }


}
