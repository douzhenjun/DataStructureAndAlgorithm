package 力扣真题.二叉树.二叉搜索树中的插入操作;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
