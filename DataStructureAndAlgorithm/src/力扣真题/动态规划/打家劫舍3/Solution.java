package 力扣真题.动态规划.打家劫舍3;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * 定义dp是一个长度为2的数组, dp[0]表示不偷该节点所得到的最大金钱, dp[1]表示偷该节点所得到的最大金钱
 *  *  使用后序遍历,因为要通过递归函数的返回值来做下一步计算
 *  *  通过递归左节点，得到左节点偷与不偷的金钱。
 *  *  通过递归右节点，得到右节点偷与不偷的金钱。
 *  *  确定单层递归的逻辑:
 *  *  如果偷当前节点,那么左右孩子就不能偷,如果不偷该节点,那么左右孩子就可以偷,至于到底偷不偷一定是选一个最大的
 * @Author douzhenjun
 * @DATE 2024-03-08
 **/
public class Solution {
    public int rob(TreeNode root){
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }
    
    int[] robAction(TreeNode root){
        int res[] = new int[2];
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
