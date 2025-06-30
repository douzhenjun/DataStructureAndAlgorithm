package 力扣真题.二叉树.二叉树的层序遍历.填充每个节点的下一个右侧节点指针;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node preNode = null;
            Node node = null;
            for(int i = 0; i < size; i++){
                if(i == 0){
                    preNode = queue.pollFirst();
                }else{
                    node = queue.pollFirst();
                    preNode.next = node;
                    preNode = preNode.next;
                }
                if(preNode.left != null){
                    queue.offerLast(preNode.left);
                }
                if(preNode.right != null){
                    queue.offerLast(preNode.right);
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
