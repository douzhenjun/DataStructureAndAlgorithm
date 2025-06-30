package 力扣真题.二叉树._1302BFS和DFS解层数最深叶子节点的和;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description 只使用一个变量sum用来记录最后一层的所有节点的和
 * @Author douzhenjun
 * @DATE 2025-02-05
 **/
public class Solution2 {
    private int maxLevel = 0;
    private int sum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(level > maxLevel){
            maxLevel = level;
            sum = 0;
        }
        if(level == maxLevel){
            sum += root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
