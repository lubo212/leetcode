package 链表.简单;

/**
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。
 * 换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 */

import 链表.ListNode;

/**
 * 解决思路： 双指针算法
 * 假设 A，B 为双链表起点，O为相交点，C为重点。 A链表遍历链路： AO+OC, B链表遍历链路： BO+OC.
 * 假设A链表遍历完成后在遍历一遍B链表， 则执行链路：AO+OC+BO+OC.
 * 同理B链表执行链路：BO+OC+AO+OC.
 * 此时：A链路 = B链路： AO+OC+BO+OC=BO+OC+AO+OC   消掉OC段,AB执行重点均为O。
 */
public class 链表相交 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNodeA = headA;
        ListNode listNodeB = headB;

        while (listNodeA != listNodeB) {
            if (listNodeA == null) {
                listNodeA = headB;
            } else {
                listNodeA = listNodeA.next;
            }
            if (listNodeB == null) {
                listNodeB = headA;
            } else {
                listNodeB = listNodeB.next;
            }
        }
        return listNodeA;
    }

}

