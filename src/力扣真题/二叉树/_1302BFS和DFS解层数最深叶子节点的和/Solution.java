package 力扣真题.二叉树._1302BFS和DFS解层数最深叶子节点的和;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 使用sumList暂存每一层的节点的和,然后去最后一个下标的元素.
 * @Author douzhenjun
 * @DATE 2024-12-06
 **/
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        List<Integer> sumList = new ArrayList<>();
        int level = 0;
        dfs(root, sumList, 0);
        return sumList.get(sumList.size() - 1);
    }

    //sumList第index位置的元素表示的是第level+1层的结点的和
    private void dfs(TreeNode root, List<Integer> sumList, int level) {
        if (root == null) {
            return;
        }
        if (level > sumList.size() - 1) {
            //如果是第一次到第level层,也就是sumList.size()<level-1
            sumList.add(root.val);
        } else {
            //sumList的第level层元素更新
            sumList.set(level, sumList.get(level) + root.val);
        }
        dfs(root.left, sumList, level + 1);
        dfs(root.right, sumList, level + 1);
    }

}
