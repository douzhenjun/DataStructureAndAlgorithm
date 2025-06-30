package 力扣真题.二叉树.二叉树的最近公共祖先;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-21
 **/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode == null && rightNode == null){
            return null;
        }else if(leftNode == null && rightNode != null){
            return rightNode;
        }else if(leftNode != null && rightNode == null){
            return leftNode;
        }else{
            return root;
        }
    }
}
