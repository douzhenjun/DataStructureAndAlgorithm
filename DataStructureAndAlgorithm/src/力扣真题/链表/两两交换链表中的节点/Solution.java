package 力扣真题.链表.两两交换链表中的节点;

import 力扣真题.链表.链表节点.ListNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-20
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode currentNode = mockHead;
        while (currentNode.next != null && currentNode.next.next != null) {
            //交换节点
            ListNode temp1 = currentNode.next;
            ListNode temp2 = currentNode.next.next.next;
            currentNode.next = temp1.next;
            currentNode.next.next = temp1;
            currentNode.next.next.next = temp2;
            //更新currentNode
            currentNode = currentNode.next.next;
        }
        return mockHead.next;
    }
}
