package 力扣真题.二叉树.二叉搜索树中的搜索;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        TreeNode result = null;
        if(root.val > val){
            result = searchBST(root.left, val);
        }
        if(root.val < val){
            result = searchBST(root.right, val);
        }
        return result;
    }
}
