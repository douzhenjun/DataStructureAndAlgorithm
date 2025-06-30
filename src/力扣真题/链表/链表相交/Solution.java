package 力扣真题.链表.链表相交;

import 力扣真题.链表.链表节点.ListNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-21
 **/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        //计算两个链表的长度差
        int offset = lenA > lenB ? lenA - lenB : lenB - lenA;
        //重置curA,curB
        curA = headA;
        curB = headB;
        //如果lenA<lenB,那么交换curA和curB
        if (lenA < lenB) {
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        //让curA走offset步,然后接下来和curB比较是否有节点相同
        //重置curA=headA, curB=headB(写在这里不对)
        // curA = headA;
        // curB = headB;
        while (offset-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
