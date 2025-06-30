package 力扣真题.二叉树.二叉树的最小深度;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public int minDepth(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if(root == null){
            return depth;
        }
        queue.offerLast(root);
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                if(node.left == null && node.right == null){
                    return depth;
                }else if(node.left != null){
                    queue.offerLast(node.left);
                    if(node.right != null){
                        queue.offerLast(node.right);
                    }
                }else if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
        }
        return depth;
    }
}
