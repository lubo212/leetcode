package 链表.简单;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */


import 链表.ListNode;

/**
 * 解题思路:
 * 快慢指针， 假设有AB两个人在一个环状操场跑步，A速率是B的二倍，则必然在环状操场的某个位置，AB相遇，此题同理
 */

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next == null){
            return false;
        }
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        int interval = 0;

        while (fastNode != slowNode && fastNode.next != null) {
            fastNode = fastNode.next;
            if (interval++ % 2 == 0){
                slowNode = slowNode.next;
            }
        }
        if (fastNode.next == null){
            return false;
        } else {
            return true;
        }

    }

}
