package 力扣真题.二叉树.对称二叉树.判断一棵树是不是另一棵树的子树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description 对称二叉树的衍生题型。判断subRoot是否是Root的子树，只要层序遍历Root的节点，
 * 并且判断以该节点为根节点的子树是否和subRoot完全相同即可。
 * @Author douzhenjun
 * @DATE 2024-02-25
 **/
public class Solution {
    
    private boolean compare(TreeNode root1, TreeNode root2){
        if(root1 != null && root2 == null){
            return false;
        }else if(root1 == null && root2 != null){
            return false;
        }else if(root1 == null && root2 == null){
            return true;
        }else if(root1.val != root2.val){
            return false;
        }else{
            return compare(root1.left, root2.left) && compare(root1.right, root2.right);
        }
    }
    
    public boolean isSubTree(TreeNode root, TreeNode subRoot){
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return compare(root, subRoot) || compare(root.left, subRoot) || compare(root.right, subRoot);
    }
}
