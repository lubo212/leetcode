package 链表.中等;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */


import com.sun.jmx.snmp.SnmpNull;
import 链表.ListNode;

/**
 * 解题思路：
 * 遍历链表，由计数器统计步数，根据步数分辨奇偶节点，并放置到对应奇偶链表下
 */

public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next.next;
        ListNode oddHead = head;
        ListNode oddTail = oddHead;

        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        oddTail.next = null;
        evenTail.next = null;

        int interval = 0;
        while (node != null) {
            if (++interval % 2 == 0) {
                evenTail.next = node;
                node = node.next;
                evenTail = evenTail.next;
                evenTail.next = null;
            } else {
                oddTail.next = node;
                node = node.next;
                oddTail = oddTail.next;
                oddTail.next = null;
            }
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}
