package 链表.简单;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */


import 链表.ListNode;

/**
 * 解题思路：
 * 1.快慢指针查找中间节点
 * 2.反转后一半的链表
 * 3.逐个比较
 * 时间复杂度：O(n)
 */

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Boolean result = true;
        //获取中间节点
        ListNode middleNode = getMiddleNode(head);
        //中间节点往后的节点全部反转
        ListNode listNode = reverseLink(middleNode.next);
        //比较节点值
        while (head != null && listNode != null) {
            if (head.val != listNode.val) {
                result = false;
                break;
            }
            head = head.next;
            listNode = listNode.next;
        }
        return result;
    }

    /**
     * 给定head，获取中间节点
     *
     * @param head
     * @return
     */
    private ListNode getMiddleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        int interval = 0;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            if (++interval % 2 == 0) {
                slowNode = slowNode.next;
            }
        }
        return slowNode;
    }

    /**
     * 给定head，反转链表
     *
     * @param node
     * @return
     */
    private ListNode reverseLink(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode head = node;
        while (node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}
