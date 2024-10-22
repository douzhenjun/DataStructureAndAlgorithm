package 力扣真题.二叉树.翻转二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }
}
