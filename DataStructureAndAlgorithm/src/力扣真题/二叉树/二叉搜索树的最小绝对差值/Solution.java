package 力扣真题.二叉树.二叉搜索树的最小绝对差值;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return Integer.MAX_VALUE;
        }
        int leftMinDiff = getMinimumDifference(root.left);
        if(root.left != null){
            TreeNode cur = root.left;
            while(cur.right != null){
                cur = cur.right;
            }
            int leftDiff = Math.abs(cur.val - root.val);
            if(leftDiff < leftMinDiff){
                leftMinDiff = leftDiff;
            }
        }
        int rightMinDiff = getMinimumDifference(root.right);
        if(root.right != null){
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }
            int rightDiff = Math.abs(cur.val - root.val);
            if(rightDiff < rightMinDiff){
                rightMinDiff = rightDiff;
            }
        }
        return leftMinDiff - rightMinDiff > 0 ? rightMinDiff : leftMinDiff;
    }
}