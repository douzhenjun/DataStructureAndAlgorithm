package 力扣真题.链表.删除链表的倒数第N个结点;

import 力扣真题.链表.链表节点.ListNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-20
 **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null){
            return null;
        }
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode fast = mockHead;
        ListNode slow = mockHead;
        int offset = 0;
        while(offset < n + 1){
            fast = fast.next;
            offset++;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //执行删除操作
        slow.next = slow.next.next;
        return mockHead.next;
    }
}
