package 力扣真题.二叉树.找树左下角的值;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-25
 **/
public class Solution {
    int maxDepth = Integer.MIN_VALUE;
    int result;
    
    public void traversal(TreeNode root, int depth){
        if(root.left == null && root.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                result = root.val;
            }
            return;
        }
        if(root.left != null){
            depth++;
            traversal(root.left, depth);
            depth--;
        }
        if(root.right != null){
            depth++;
            traversal(root.right, depth);
            depth--;
        }
        return;
    }
    
    public int findBottomLeftValue(TreeNode root){
        traversal(root, 0);
        return result;
    }
}
