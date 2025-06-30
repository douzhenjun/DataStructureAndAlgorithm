package 力扣真题.二叉树.判断路径之和是否等于指定值.返回是否存在;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Stack;

/**
 * @Description 非递归写法
 * @Author douzhenjun
 * @DATE 2024-02-25
 **/
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();
                if (node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}
