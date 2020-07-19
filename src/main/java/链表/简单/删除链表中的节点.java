package 链表.简单;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 说明:
 *
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */


import 链表.ListNode;

/**
 * 解题思路：
 * 没有思路，前移下一个节点值
 */
public class 删除链表中的节点 {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
