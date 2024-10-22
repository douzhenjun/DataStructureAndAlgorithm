package 剑指offer.剑指offer18_删除链表结点操作.linkedlistdemo;

public class LinkedList {
    //头结点
    private Node head = new Node();

    /**
     * 获得一个头结点,一般来说每个链表要有一个头结点,它的数据域为0,每次的操作都要从这个头指针开始查询
     * @return
     */
    public Node getHead() {
        return head;
    }

    /**
     * 增加一个结点
     * @param node
     * @return
     */
    public boolean add(Node node){
        //指针pNode指向头结点
        Node pNode = getHead();
        while(pNode.getNext() != null){
            pNode = pNode.getNext();
        }
        pNode.setNext(node);
        return true;
    }

    /**
     * 删除一个结点
     * @param node
     * @return
     */
    public boolean remove(Node node){
        Node pNode = getHead();
        //只要找到pNode的next结点是node就停止
        while(pNode.getNext() != node){
            pNode = pNode.getNext();
        }
        if(pNode == null){
            System.out.println("这个链表中没有指定的要删除的结点.");
            return false;
        }
        //让pNode的next指针指向node的next结点,node因为变成了无指针对象所以被自动回收
        pNode.setNext(node.getNext());
        return true;
    }

    /**
     * 查找一个结点
     * @param value
     * @return
     */
    public Node search(int value){
        Node pNode = getHead();
        while(pNode != null){
            if(pNode.getValue() == value){
               return pNode;
            }
            pNode = pNode.getNext();
        }
        return null;
    }

    /**
     * 遍历整个链表,并打印出所有的数据
     */
    public void traverse(){
        Node pNode = getHead();
        while(pNode.getNext() != null){
            pNode = pNode.getNext();
            System.out.print(pNode.getValue());
            System.out.print("->");
        }
        System.out.println("null");
    }
}
