package 力扣真题.二叉树.判断是否是平衡二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-31
 **/
public class Solution {
    
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        return getHeight(root) != -1;
    }
    
    //获得二叉树某一个节点的高度
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}