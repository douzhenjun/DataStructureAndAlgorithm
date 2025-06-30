package 力扣真题.二叉树._1609奇偶树;

import org.junit.Test;
import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import javax.swing.table.TableRowSorter;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-11-10
 **/
public class TestDemo {
    Solution solution = new Solution();
    
    @Test
    public void test1(){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(4);
        TreeNode node11 = new TreeNode(3);
        TreeNode node21 = new TreeNode(7);
        TreeNode node22 = new TreeNode(9);
        TreeNode node111 = new TreeNode(12);
        TreeNode node112 = new TreeNode(8);
        TreeNode node211 = new TreeNode(6);
        TreeNode node222 = new TreeNode(2);
        node.left = node1;
        node.right = node2;
        node1.left = node11;
        node2.left = node21;
        node2.right = node22;
        node11.left = node111;
        node11.right = node112;
        node21.left = node211;
        node22.right = node222;

        System.out.println(solution.isEvenOddTree(node));
    }
}
