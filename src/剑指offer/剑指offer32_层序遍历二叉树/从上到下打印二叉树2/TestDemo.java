package 剑指offer.剑指offer32_层序遍历二叉树.从上到下打印二叉树2;

import 二叉树.二叉树节点类.TreeNode;

/**
 * @author dou_zhenjun
 * @date 2023/3/12
 */
public class TestDemo {

    /**
     * @Description 完全二叉树测试
     *           8
     *        6     10
     *     5   7  9     11
     */
    @org.junit.Test
    public void test01(){
        TreeNode root = new TreeNode(8);
        root.setLeft(new TreeNode(6));
        root.setRight(new TreeNode(10));
        root.getLeft().setLeft(new TreeNode(5));
        root.getLeft().setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(9));
        root.getRight().setRight(new TreeNode(11));

        PrintByFloor2.printTreeNode(root);
    }

    /**
     * @Description 所有节点只有左子树(或右子树)
    8
    6
    5
    7
    9
     */
    @org.junit.Test
    public void test02(){
        TreeNode root = new TreeNode(8);
        root.setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(5));
        root.getRight().getRight().setRight(new TreeNode(7));
        root.getRight().getRight().getRight().setRight(new TreeNode(9));
        PrintByFloor2.printTreeNode(root);

        System.out.println();

        TreeNode root2 = new TreeNode(8);
        root2.setLeft(new TreeNode(6));
        root2.getLeft().setLeft(new TreeNode(5));
        root2.getLeft().getLeft().setLeft(new TreeNode(7));
        root2.getLeft().getLeft().getLeft().setLeft(new TreeNode(9));
        PrintByFloor2.printTreeNode(root2);
    }

    /**
     * @Description 根节点为null的二叉树, 根节点只有一个的二叉树
     */
    @org.junit.Test
    public void test03(){
        TreeNode root = null;
        PrintByFloor2.printTreeNode(root);

        root = new TreeNode(1);
        PrintByFloor2.printTreeNode(root);
    }
}
