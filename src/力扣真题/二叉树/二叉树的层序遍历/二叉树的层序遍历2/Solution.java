package 力扣真题.二叉树.二叉树的层序遍历.二叉树的层序遍历2;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int depth = 0;
        List<List<Integer>> result = new ArrayList<>();
        order(root, result, depth);
        int size = result.size();
        for(int i = 0; i < size / 2; i++){
            int j = size-1-i;
            List<Integer> temp =  result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
        }
        return result;
    }

    private void order(TreeNode root, List<List<Integer>> list, int depth){
        if(root == null){
            return;
        }
        if(depth + 1 > list.size()){
            list.add(new ArrayList<Integer>());
        }
        list.get(depth).add(root.val);
        order(root.left, list, depth+1);
        order(root.right, list, depth+1);
    }
}
