package 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        ll.add(node1);
        ll.add(node2);
        ll.add(node3);
        ll.traverse();//1->2->3->null

        //删除结点node2
        ll.remove(node2);
        ll.traverse();//1->3->null

        //找到保存数据1的结点,并改这个数据为4
        Node node4 = ll.search(1);
        node4.setValue(4);
        ll.traverse();//4->3->null

    }
}
