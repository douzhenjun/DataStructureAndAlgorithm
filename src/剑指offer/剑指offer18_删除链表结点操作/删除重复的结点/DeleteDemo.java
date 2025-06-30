package 剑指offer.剑指offer18_删除链表结点操作.删除重复的结点;

import 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo.LinkedList;
import 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo.Node;

public class DeleteDemo {
    public static void main(String[] args) {
        //尾部有重复
        LinkedList lst = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        lst.add(node1);
        lst.add(node2);
        lst.add(node3);
        lst.add(node4);

        lst.traverse();

        DeleteDuplication de = new DeleteDuplication();
        de.deleteDuplication(lst);
        lst.traverse();


        //中间有重复
        LinkedList lst1 = new LinkedList();
        Node node11 = new Node(1);
        Node node12 = new Node(3);
        Node node13 = new Node(3);
        Node node14 = new Node(4);
        lst1.add(node11);
        lst1.add(node12);
        lst1.add(node13);
        lst1.add(node14);
        lst1.traverse();
        de.deleteDuplication(lst1);
        lst1.traverse();

        //全部有重复
        LinkedList lst2 = new LinkedList();
        Node node21 = new Node(3);
        Node node22 = new Node(3);
        Node node23 = new Node(3);
        Node node24 = new Node(3);
        lst2.add(node21);
        lst2.add(node22);
        lst2.add(node23);
        lst2.add(node24);
        lst2.traverse();
        de.deleteDuplication(lst2);
        lst2.traverse();

        //全部无重复
        LinkedList lst3 = new LinkedList();
        Node node31 = new Node(3);
        Node node32 = new Node(4);
        Node node33 = new Node(5);
        Node node34 = new Node(6);
        lst3.add(node31);
        lst3.add(node32);
        lst3.add(node33);
        lst3.add(node34);
        lst3.traverse();
        de.deleteDuplication(lst3);
        lst3.traverse();
    }
}
