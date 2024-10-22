package 力扣真题.二叉树.二叉搜索树中的众数.根据二叉搜索树特性的解法;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-21
 **/
public class Solution3 {

    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> resList = new ArrayList<>();
    
    public int[] findMode(TreeNode root){
        searchBST(root);
        int[] result = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++){
            result[i] = resList.get(i);
        }
        return result;
    }

    private void searchBST(TreeNode root){
        if(root == null){
            return;
        }
        searchBST(root.left);
        if(pre == null || root.val != pre.val){
            count = 1;
        }else{
            count++;
        }
        if(count > maxCount){
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            resList.add(root.val);
        }
        pre = root;
        searchBST(root.right);
    }
}
