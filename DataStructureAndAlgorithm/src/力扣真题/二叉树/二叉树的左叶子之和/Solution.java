package 力扣真题.二叉树.二叉树的左叶子之和;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class Solution {
    public int sumOfLeftLeaves(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfLeftLeaves(root.left);
        if(root.left != null && root.left.left == null && root.left.right == null){
            leftSum = root.left.val;
        }
        int rightSum = sumOfLeftLeaves(root.right);
        return leftSum + rightSum;
    }
}
