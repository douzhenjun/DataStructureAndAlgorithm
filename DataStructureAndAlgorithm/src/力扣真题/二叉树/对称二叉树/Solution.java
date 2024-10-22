package 力扣真题.二叉树.对称二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-25
 **/
public class Solution {
    public boolean isSymmetricTree(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left != null && right == null){
            return false;
        }else if(left == null && right != null){
            return false;
        }else if(left == null && right == null){
            return true;
        }else {//left != null && right != null
            if(left.val != right.val){
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
