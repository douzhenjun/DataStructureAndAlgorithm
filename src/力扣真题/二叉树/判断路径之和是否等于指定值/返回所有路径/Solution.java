package 力扣真题.二叉树.判断路径之和是否等于指定值.返回所有路径;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-26
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<Integer> paths = new ArrayList<>();
        traversal(root, targetSum, paths);
        return result;
    }
    
    private void traversal(TreeNode root, int targetSum, List<Integer> paths){
        if(root == null){
            return;
        }
        paths.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val){
            List<Integer> paths2 = new ArrayList<>(paths);//复制了一个新的对象,这样不影响后续对paths的修改
            result.add(paths2);
        }
        if(root.left != null){
            traversal(root.left, targetSum-root.val, paths);
            paths.remove(paths.size()-1);
        }
        if(root.right != null){
            traversal(root.right, targetSum-root.val, paths);
            paths.remove(paths.size()-1);
        }
    }
}
