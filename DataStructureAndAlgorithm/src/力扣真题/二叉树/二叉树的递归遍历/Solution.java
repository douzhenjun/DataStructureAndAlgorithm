package 力扣真题.二叉树.二叉树的递归遍历;

import 二叉树.二叉树节点类.TreeNode;

/**
 * @Description 二叉树的递归遍历
 * @Author douzhenjun
 * @DATE 2024-01-20
 **/
public class Solution {
    protected void traversalPre(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.getData());
        if(root.getLeft() != null){
            traversalPre(root.getLeft());
        }
        if(root.getRight() != null){
            traversalPre(root.getRight());
        }
    }

    protected void traversalMiddle(TreeNode root){
        if(root == null){
            return;
        }
        if(root.getLeft() != null){
            traversalMiddle(root.getLeft());
        }
        System.out.println(root.getData());
        if(root.getRight() != null){
            traversalMiddle(root.getRight());
        }
    }

    protected void traversalPost(TreeNode root){
        if(root == null){
            return;
        }
        if(root.getLeft() != null){
            traversalPost(root.getLeft());
        }
        if(root.getRight() != null){
            traversalPost(root.getRight());
        }
        System.out.println(root.getData());
    }
}
