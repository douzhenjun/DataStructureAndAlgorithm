package 力扣真题.二叉树.验证二叉搜索树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description 使用递归方式,直接利用二叉搜索树的定义来判断
 * @Author douzhenjun
 * @DATE 2024-02-26
 **/
public class  Solution3 {
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        boolean leftValue = isValidBST(root.left);
        boolean rightValue = isValidBST(root.right);
        
        TreeNode leftCur = root.left;
        TreeNode rightCur = root.right;
        if(leftCur == null && rightCur != null){
            while(rightCur.left != null){
                rightCur = rightCur.left;
            }
            return root.val < root.right.val && rightValue && root.val < rightCur.val;
        }else if(leftCur != null && rightCur == null){
            while(leftCur.right != null){
                leftCur = leftCur.right;
            }
            return root.left.val < root.val && leftValue && leftCur.val < root.val;
        }else{
            while(leftCur.right != null){
                leftCur = leftCur.right;
            }
            while(rightCur.left != null){
                rightCur = rightCur.left;
            }
            return root.left.val < root.val && root.val < root.right.val
                    && leftValue && rightValue
                    && leftCur.val < root.val
                    && root.val < rightCur.val;
        }
    }
}
