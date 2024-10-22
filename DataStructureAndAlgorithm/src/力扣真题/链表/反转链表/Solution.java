package 力扣真题.链表.反转链表;

import 力扣真题.链表.链表节点.ListNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-20
 **/
public class Solution {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

