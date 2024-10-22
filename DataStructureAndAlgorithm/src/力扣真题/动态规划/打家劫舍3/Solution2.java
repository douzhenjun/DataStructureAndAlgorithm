package 力扣真题.动态规划.打家劫舍3;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 *  
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution2 {
    public int rob(TreeNode root){
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robAction(root, memo);
    }
    
    public int robAction(TreeNode root, Map<TreeNode, Integer> memo){
        if(root == null){
            return 0;
        }
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        int money = root.val;
        if(root.left != null){
            money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        }
        if(root.right != null){
            money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
        }
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        return res;
    }
}
