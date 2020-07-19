package 链表.简单;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */


import 链表.ListNode;

/**
 * 解决思路：
 * 基本解法，遍历删除即可
 */

public class 删除中间节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
