package 力扣真题.二叉树.判断是否是平衡二叉树;

import org.junit.Test;
import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-31
 **/
public class TestDemos {

    @Test
    public void test01(){
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(1);
        System.out.println(solution.isBalanced(root1));
    }

    @Test
    public void test02(){
        Solution solution = new Solution();
        TreeNode root2 = new TreeNode(1);
        root2.setLeft(new TreeNode(2));
        root2.getLeft().setLeft(new TreeNode(3));
        System.out.println(solution.isBalanced(root2));
    }

    @Test
    public void test03(){
        Solution solution = new Solution();
        TreeNode root3 = new TreeNode(1);
        root3.setLeft(new TreeNode(2));
        System.out.println(solution.isBalanced(root3));
    }

    @Test
    public void test04(){
        Solution solution = new Solution();
        TreeNode root4 = null;
        System.out.println(solution.isBalanced(root4));
    }
}
