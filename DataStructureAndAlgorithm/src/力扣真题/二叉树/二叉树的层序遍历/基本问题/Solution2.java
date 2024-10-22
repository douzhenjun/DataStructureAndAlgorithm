package 力扣真题.二叉树.二叉树的层序遍历.基本问题;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 递归写法
 * @Author douzhenjun
 * @DATE 2024-01-24
 **/
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        order(root, result, 0);
        return result;
    }

    //递归实现广度优先遍历方法
    private void order(TreeNode root, List<List<Integer>> result, int depth) {
        if (root == null) {
            return;
        }
        //如果数组中第depth+1层还没有创建,就创建一下
        if (result.size() == depth) {
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(root.getVal());
        order(root.getLeft(), result, depth + 1);
        order(root.getRight(), result, depth + 1);

    }
}
