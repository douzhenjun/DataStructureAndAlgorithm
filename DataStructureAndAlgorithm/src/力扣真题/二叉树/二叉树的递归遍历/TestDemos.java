package 力扣真题.二叉树.二叉树的递归遍历;

import 二叉树.二叉树节点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-20
 **/
public class TestDemos {
    /**
     * 定义这样一个二叉树 1
     *              2   3
     *            4    6  7
     *          5
     */
    public static void main(String[] args) {
        //初始化二叉树
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().getLeft().setLeft(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        
        Solution solution = new Solution();
        System.out.println("前序遍历结果:");
        solution.traversalPre(root);
        System.out.println("中序遍历结果:");
        solution.traversalMiddle(root);
        System.out.println("后序遍历结果:");
        solution.traversalPost(root);
    }
}
