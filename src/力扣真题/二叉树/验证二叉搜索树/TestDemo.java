package 力扣真题.二叉树.验证二叉搜索树;

import org.junit.Test;
import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class TestDemo {
    @Test
    public void test01(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);
        right1.left = new TreeNode(3);
        right1.right = new TreeNode(6);
        root.right = right1;
        
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
    
    @Test
    public void test02(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}
