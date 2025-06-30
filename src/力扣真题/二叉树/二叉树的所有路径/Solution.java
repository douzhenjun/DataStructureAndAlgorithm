package 力扣真题.二叉树.二叉树的所有路径;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        getPath(root, path, result);
        return result;
    }

    private void getPath(TreeNode root, List<Integer> path, List<String> result){
        if(root != null){
            path.add(root.val);
        }
        //如果是叶子节点,那么将path中的int元素转换成字符串加上->连接,再存入result中
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
            getPath(root.left, path, result);//将root的左孩子添加到path中
            path.remove(path.size()-1);//回溯,弹出最后添加的元素
        }
        if(root.right != null){
            getPath(root.right, path, result);
            path.remove(path.size()-1);
        }
    }
}
