package 力扣真题.二叉树.二叉搜索树中的众数;

import com.sun.source.tree.Tree;
import 力扣真题.二叉树.二叉搜索树中的众数.根据二叉搜索树特性的解法.Solution2;
import 力扣真题.二叉树.二叉搜索树中的众数.根据二叉搜索树特性的解法.Solution3;
import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-21
 **/
public class TestDemos {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(Arrays.toString(solution.findMode(root)));
        
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(2);
        Solution2 solution2 = new Solution2();
//        System.out.println(Arrays.toString(solution2.findMode(root2)));

        Solution3 solution3 = new Solution3();
        System.out.println(Arrays.toString(solution3.findMode(root2)));
    }
}
