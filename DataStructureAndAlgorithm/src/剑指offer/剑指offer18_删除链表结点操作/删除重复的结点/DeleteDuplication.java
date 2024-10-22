package 剑指offer.剑指offer18_删除链表结点操作.删除重复的结点;

import 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo.LinkedList;
import 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo.Node;

public class DeleteDuplication {
    public static void deleteDuplication(LinkedList lst){
        Node p = lst.getHead();
        Node q = p.getNext();
        while(q != null){
            if(p.getValue() == q.getValue()){
                lst.remove(q);
                q = q.getNext();
            }else{
                q = q.getNext();
                p = p.getNext();
            }
        }
    }
}
