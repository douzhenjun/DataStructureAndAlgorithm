package 力扣真题.链表.反转链表;

import 力扣真题.链表.链表节点.ListNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-20
 **/
public class TestDemos {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        ListNode node1 = node.next;
        node1.next = new ListNode(3);
        ListNode node2 = node1.next;
        node2.next = new ListNode(4);
        ListNode node3 = node2.next;
        node3.next = new ListNode(5);
        ListNode node4 = node3.next;
        System.out.println("反转以前");
        ListNode root = node;
        while(root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
        solution.reverseList(node);
        System.out.println("反转以后");
        root = node4;
        while(root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}
