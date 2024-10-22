package 力扣真题.二叉树.二叉搜索树的最小绝对差值;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-21
 **/
public class Solution2 {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root){
        traversal(root);
        return result;
    }
    
    public void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        if(pre != null){
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
