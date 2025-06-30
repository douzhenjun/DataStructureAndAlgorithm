package 力扣真题.二叉树.二叉搜索树中的众数.test;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution2 {
    int count = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();
    Integer pre = null;
    public int[] findMode(TreeNode root){
        traverse(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        if(pre == null || pre == root.val) {
            count++;
        }else{
            count = 1;
        }
        pre = root.val;
        if(count > maxCount){
            maxCount = count;
            result.clear();
            result.add(root.val);
        }else if(count == maxCount){
            result.add(root.val);
        }
        traverse(root.right);
    }
}
