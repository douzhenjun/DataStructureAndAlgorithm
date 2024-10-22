package 力扣真题.二叉树.二叉搜索树中的删除操作;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.right != null && root.left == null){
                return root.right;
            }else{
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
