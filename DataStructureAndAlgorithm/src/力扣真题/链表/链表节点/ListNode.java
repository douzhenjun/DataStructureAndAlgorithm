package 力扣真题.链表.链表节点;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-20
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
