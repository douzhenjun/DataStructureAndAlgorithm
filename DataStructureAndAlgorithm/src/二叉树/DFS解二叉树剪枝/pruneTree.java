package 二叉树.DFS解二叉树剪枝;


import 二叉树.二叉树节点类.TreeNode;

public class pruneTree {
    public TreeNode pruneTree(TreeNode root){
        if(root == null){
            return null;
        }
        root.setLeft(root.getLeft());
        root.setRight(root.getRight());
        
        if(root.getLeft() == null && root.getRight() == null && root.getData() == 0){
            return null;
        }
        return root;
    }
}
