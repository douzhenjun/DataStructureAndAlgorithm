package 力扣真题.二叉树.找树左下角的值.迭代法;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-21
 **/
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            result = queue.peekFirst().val;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                if(node.left != null){
                    queue.offerLast(node.left);
                }
                if(node.right != null){
                    queue.offerLast(node.right);
                }
            }
        }
        return result;
    }
}