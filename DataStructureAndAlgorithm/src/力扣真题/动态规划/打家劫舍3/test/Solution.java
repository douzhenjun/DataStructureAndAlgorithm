package 力扣真题.动态规划.打家劫舍3.test;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-14
 **/
public class Solution {
    public int rob(TreeNode root){
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);        
    }
    
    private int[] robAction(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
