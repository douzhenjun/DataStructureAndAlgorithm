package 剑指offer.剑指offer32_层序遍历二叉树.之字形打印二叉树;

import org.junit.Test;
import 二叉树.二叉树节点类.TreeNode;

/**
 * @author dou_zhenjun
 * @date 2023/3/16
 */
public class TestDemo {
    
    @Test
    public void test01(){
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getLeft().getLeft().setLeft(new TreeNode(8));
        root.getLeft().getLeft().setRight(new TreeNode(9));
        root.getLeft().getRight().setLeft(new TreeNode(10));
        root.getLeft().getRight().setRight(new TreeNode(11));
        root.getRight().getLeft().setLeft(new TreeNode(12));
        root.getRight().getLeft().setRight(new TreeNode(13));
        root.getRight().getRight().setLeft(new TreeNode(14));
        root.getRight().getRight().setRight(new TreeNode(15));
        
        PrintByFloorLikeZ.PrintTreeData(root);
    }

    @Test
    public void test02(){
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        
        root.getLeft().setLeft(new TreeNode(4));
        
        root.getLeft().getLeft().setLeft(new TreeNode(8));
       

        PrintByFloorLikeZ.PrintTreeData(root);
    }

    @Test
    public void test03(){
        TreeNode root = new TreeNode(1);
        
        root.setRight(new TreeNode(3));
        
        root.getRight().setRight(new TreeNode(7));
        
        root.getRight().getRight().setRight(new TreeNode(15));

        PrintByFloorLikeZ.PrintTreeData(root);
    }

    @Test
    public void test04(){
        TreeNode root = new TreeNode(1);
        PrintByFloorLikeZ.PrintTreeData(root);
        root = null;
        PrintByFloorLikeZ.PrintTreeData(root);
    }
}
