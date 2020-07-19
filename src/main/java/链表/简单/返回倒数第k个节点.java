package 链表.简单;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */


import 链表.ListNode;

/**
 * 解题思路：
 * 快慢指针
 */

public class 返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        if (head == null){
            return -1;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        int interval = 0;

        while (fastNode != null){
            fastNode = fastNode.next;
            interval++;
            if (interval > k){
                slowNode= slowNode.next;
            }
        }
        return slowNode.val;

    }
}
