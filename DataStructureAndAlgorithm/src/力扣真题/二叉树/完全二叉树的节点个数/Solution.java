package 力扣真题.二叉树.完全二叉树的节点个数;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = 1;
        int rightDepth = 1;
        TreeNode cur = root;
        while(cur != null){
            cur = cur.left;
            leftDepth++;
        }
        while(cur != null){
            cur = cur.right;
            rightDepth++;
        }
        if(leftDepth == rightDepth){
            return 2 << leftDepth - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
