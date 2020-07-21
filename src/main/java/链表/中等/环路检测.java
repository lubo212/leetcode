package 链表.中等;
/**
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 */

import 链表.ListNode;

/**
 * 解题思路：
 * 快慢指针（快指针步长为慢指针2倍）：假设表头到环口距离=a，环口到第一次相遇点距离=b，第一次相遇点到环口距离=c
 * 1.则第一次相遇时，慢指针步长: f(slow) = a + b, 快指针步长: f(fast) = a + x(b + c) + b ,其中x为绕环次数
 * 2.因为：2f(slow) = f(fast) , so : 2(a+b) = a+x(b+c)+b 。
 * 3.化简得a=(x-1)(b+c)+c ,该公式可以理解为：表头到环口的距离 = 绕（x-1）圈环后，再加上c的距离
 * 4. （如果公式3  左侧公式的起始点为表头，右侧公式的起始点为相遇点，按照同样步长前进，相遇点即为环口点）
 * 解法：
 * 1. 快慢指针，步长相差两倍，查找第一次相遇点，标记相遇点
 * 2. 双指针，一指针从链头开始执行，一指针从相遇点执行，步长均为1，相遇点即环口点
 */

public class 环路检测 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode ){
                break;
            }
        }

        if (fastNode == null || fastNode.next == null){
            return null;
        }
        ListNode one = head;
        ListNode two = fastNode;
        while (one!=two){
            one = one.next;
            two = two.next;
        }
        return one;

    }



}
