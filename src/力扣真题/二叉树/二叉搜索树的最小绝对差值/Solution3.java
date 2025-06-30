package 力扣真题.二叉树.二叉搜索树的最小绝对差值;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-21
 **/
public class Solution3 {
    public int getMinimumDifference(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        while(cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }else{
                cur = st.peek();
                st.pop();
                if(pre != null){
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}
