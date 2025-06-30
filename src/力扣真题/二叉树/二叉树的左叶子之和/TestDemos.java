package 力扣真题.二叉树.二叉树的左叶子之和;

import org.junit.Test;
import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class TestDemos {
    Solution solution = new Solution();

    @Test
    public void test01(){
        TreeNode node = new TreeNode(1);
        System.out.println(solution.sumOfLeftLeaves(node));
    }
    @Test
    public void test02(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        System.out.println(solution.sumOfLeftLeaves(node));
    }
    @Test
    public void test03(){
        TreeNode node = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        left1.left = new TreeNode(1);
        TreeNode right1 = new TreeNode(1);
        right1.left = new TreeNode(1);
        node.left = left1;
        node.right = right1;
        System.out.println(solution.sumOfLeftLeaves(node));
    }
    
    @Test
    public void test04(){
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(1);
        node.right.right = new TreeNode(1);
        node.right.right.right = new TreeNode(1);
        System.out.println(solution.sumOfLeftLeaves(node));
    }
}
