package 剑指offer.剑指offer32_层序遍历二叉树.从上到下打印二叉树;

import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 按照从上倒下的顺序打印二叉树
 */
public class PrintByFloor {

    public static void printTreeNode(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            System.out.println("二叉树不能为空!");
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.peek();
            if(top.getLeft() != null){
                queue.offer(top.getLeft());
            }
            if(top.getRight() != null){
                queue.offer(top.getRight());
            }
            System.out.printf("%5d",queue.poll().getData());
        }
    }


}
