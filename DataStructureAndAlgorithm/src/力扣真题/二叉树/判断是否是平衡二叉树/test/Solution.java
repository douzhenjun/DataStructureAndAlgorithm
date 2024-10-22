package 力扣真题.二叉树.判断是否是平衡二叉树.test;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-21
 **/
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode topNode = stack.peek();
                if(topNode.right == null || topNode.right == pre){
                    if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
                        return false;
                    }
                    stack.pop();
                    pre = topNode;
                }else{
                    cur = cur.right;
                }
            }
        }
        return true;
    }
    
    
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while(!deque.isEmpty()){
            depth++;
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode topNode = deque.peek();
                deque.pop();
                if(topNode.left != null){
                    deque.offer(topNode.left);
                }
                if(topNode.right != null){
                    deque.offer(topNode.right);
                }
            }
        }
        return depth;
    }
}
