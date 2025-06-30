package 力扣真题.链表.环形链表II;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-09
 **/
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }

    public ListNode(){
        val = Integer.MAX_VALUE;
    }
}
