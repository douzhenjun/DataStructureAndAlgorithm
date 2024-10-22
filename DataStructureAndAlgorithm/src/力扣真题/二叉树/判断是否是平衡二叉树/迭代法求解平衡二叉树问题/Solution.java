package 力扣真题.二叉树.判断是否是平衡二叉树.迭代法求解平衡二叉树问题;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-31
 **/
public class Solution {

    //如果一个二叉树是平衡的,那么它的左右子树的高度差不会超过1
    //在这里我们首先遍历到所有的二叉树节点并让它们入栈,然后每次处理栈顶元素
    //遍历顺序采用后序遍历的方式进行
    //判断栈顶元素的左子树和右子树的高度差是否大于1,如果大于1返回false
    //如果栈中没有元素了,那么返回true
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        //定义指针指向上一次被出栈的节点
        TreeNode pre = null;
        //首先栈为空,先将root及其所有的左子树节点入栈,
        //如果没有root!=null这一判断条件这个循环都无法进入
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //获得栈顶元素
            TreeNode inNode = stack.peek();
            //如果栈顶元素右子树为空或者右子树指向了上一次出栈的结点,那么该节点可以出栈了
            if (inNode.right == null || inNode.right == pre) {
                //如果该节点的高度差>1，返回false
                if (Math.abs(getHeight(inNode.left) - getHeight(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                root = null;//当前节点下,没有要遍历的节点了
            } else {
                //否则,栈顶元素的右子结点入栈
                root = inNode.right;
            }
        }
        return true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }
}
