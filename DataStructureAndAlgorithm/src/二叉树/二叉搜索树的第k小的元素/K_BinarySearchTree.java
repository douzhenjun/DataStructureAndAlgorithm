package 二叉树.二叉搜索树的第k小的元素;


import 二叉树.二叉树节点类.TreeNode;

public class K_BinarySearchTree {
    
    private static int count;
    private static int target;
    
    public static int findKthSmallestNode(TreeNode root, int k){
        count = k;
        traverseInOrder(root);
        return target;
    }
    
    public static void traverseInOrder(TreeNode root){
        if(root == null){
            return;
        }
//        if(root.getLeft() != null){
            traverseInOrder(root.getLeft());
//        }
        count--;
        if(count == 0){
            target = root.getData();
        }
//        if(root.getRight() != null){
            traverseInOrder(root.getRight());
//        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode lchild1 = new TreeNode(1);
        TreeNode rchild1 = new TreeNode(4);
        TreeNode rchild2 = new TreeNode(2);
        root.setLeft(lchild1);
        root.setLeft(rchild1);
        lchild1.setLeft(rchild2);

        System.out.println(findKthSmallestNode(root, 1));
        
    }
}
