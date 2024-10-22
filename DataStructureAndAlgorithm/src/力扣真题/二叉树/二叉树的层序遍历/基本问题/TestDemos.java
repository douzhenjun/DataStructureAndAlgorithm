package 力扣真题.二叉树.二叉树的层序遍历.基本问题;


import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-24
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
        
        //开始测试非递归
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
        
        //开始测试递归
        Solution2 solution2 = new Solution2();
        List<List<Integer>> lists1 = solution2.levelOrder(root);
        System.out.println(lists1);
    }
}
