package 力扣真题.二叉树.二叉搜索树的最小绝对差值;

import 二叉树.将一个二叉树展开成链表.Transfer;
import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-20
 **/
public class TestDemos {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);
        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(root));
    }
}
