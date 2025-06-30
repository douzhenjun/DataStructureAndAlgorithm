package 二叉树.二叉树的最大宽度;

import 二叉树.二叉树节点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindMaxWideTreeNode2 {
    static int maxWide = 0;
    
    public static int getMaxWideTreeNode(TreeNode root){
        dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
        return maxWide;
    }

    private static void dfs(TreeNode root, int level, int position, List<Integer> left, List<Integer> right) {
        if(root == null){
            return;
        }
        if(left.size() == level){
            left.add(position);
            right.add(position);
        }else{
            right.set(level, position);
        }
        
        dfs(root.getLeft(), level+1, position << 1, left, right);
        dfs(root.getRight(), level+1, position*2+1, left, right);
        
        maxWide = Math.max(maxWide, right.get(level) - left.get(level));
    }
}
