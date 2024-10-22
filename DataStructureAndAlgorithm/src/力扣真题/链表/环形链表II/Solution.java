package 力扣真题.链表.环形链表II;

/**
 * @Description
 * 单链表有环指的是单链表中某个结点next域指向的是链表中在它之前的某一个结点，这样在链表的尾部形成一个环形结构
 * 判断它的存在性:
 * 如果fast指针与slow指针相遇了，说明链表里有环存在。
 * 寻找环的入口位置(第d0个结点，head.next是第一个结点):
 * 首先，可以确定如果fast跟slow相遇了，相遇的地点一定是在环内。
 * 其次，如果fast跟slow从同一地点出发，后面相遇了，那么fast一定比slow多走了n个环节点个数
 * 设环的入口节点距离头部节点为x, 相遇节点距离入口节点为y, 环中剩余节点为z.
 * 让fast指针每次走两步,slow指针每次走一步, 那么到第一次相遇时, slow指针走了x+y, fast指针走了x+y+n(y+z), n>=1.
 * 并且满足2*(x+y) = x+y+n(y+z); 其中y+z就是环的长度
 * 两边去掉一个x+y, 得, x+y = n(y+z), n>=1;
 * 从而x = n(y+z)-y = (n-1)y+nz = (n-1)(y+z)+z, n>=1;
 * 当n=1时, x = z, 这说明只要指针从相遇节点出发, 那么经过x个结点以后, 指针就会指向环的入口结点, 换言之
 * 如果另一个指针从头结点出发, 那么它们一定会在环的入口结点处相遇.
 * 当n>1时, x = (n-1)(y+z)+z, 这在环看来实际上和走z个结点没有区别, 所以这和第一种情况没有区别.
 * @Author douzhenjun
 * @DATE 2023-10-09
 **/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode mockHead = new ListNode(0);//虚拟头结点
        mockHead.next = head;
        ListNode slow = mockHead;
        ListNode fast = mockHead;
        if(fast.next == null){
            return null;
        }
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }
            if(slow == fast){
                slow = mockHead;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
