package 力扣真题.二叉树.回溯法求解二叉树的全部路径问题;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 采用
 * @Author douzhenjun
 * @DATE 2024-02-01
 **/
public class Solution {
    
    public List<String> binaryTreePaths(TreeNode root){
        List<Integer> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        getPath(root, path, result);
        return result;
    }
    
    private void getPath(TreeNode root, List<Integer> path, List<String> result){
        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size()-1; i++){
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size()-1));
            result.add(sb.toString());
        }
        if(root.left != null){
            getPath(root.left, path, result);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            getPath(root.right, path, result);
            path.remove(path.size()-1);
        }
    }
}
