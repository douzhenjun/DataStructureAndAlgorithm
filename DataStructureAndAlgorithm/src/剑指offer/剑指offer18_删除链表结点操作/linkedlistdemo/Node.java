package 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo;

public class Node {
    private int value;
    private Node next;


    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
