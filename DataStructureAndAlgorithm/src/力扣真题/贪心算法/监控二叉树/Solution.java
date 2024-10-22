package 力扣真题.贪心算法.监控二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root){
        if(minCame(root) == 0){
            res++;
        }
        return res;
    }
    
    public int minCame(TreeNode root){
        if(root == null){
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        
        if(left == 2 && right == 2){
            return 0;
        }else if(left == 0 || right == 0){
            res++;
            return 1;
        }else{
            return 2;
        }
    }
}
