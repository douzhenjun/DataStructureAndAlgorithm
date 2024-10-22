package 二叉树.二叉树的最大深度;

public class TheMaxDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode Node = new TreeNode(10);
        TreeNode Node1 = new TreeNode(2);
        Node1 = Node.left;
//        Node1.val = 2;
        TreeNode Node2 = new TreeNode(3);
        Node2 = Node.right;
//        Node2.val = 3;
        TreeNode Node3 = new TreeNode(12);
        Node3 = Node1.left;
        TreeNode Node4 = new TreeNode(44);
        Node4 = Node3.left;
//        Node3.val = 12;
//        Node4.val = 44;
//        TreeNode Node5 = Node2.left;
//        Node5 = new TreeNode(334);
////        Node5.val = 334;
//        TreeNode Node6 = Node3.right;
//        Node6 = new TreeNode(343);
////        Node6.val = 343;
        System.out.println("这个二叉树的先序遍历为:\n");
        Node.preOrder(Node);
        System.out.println("这个二叉树的最大深度为:\n");
        Node.maxDepth(Node);
    }


}
