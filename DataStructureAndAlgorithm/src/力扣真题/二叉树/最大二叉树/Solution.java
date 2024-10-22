package 力扣真题.二叉树.最大二叉树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findNode(nums, 0, nums.length);
    }

    private TreeNode findNode(int[] nums, int begin, int end){
        if(begin >= end){
            return null;
        }
        int max = -1;//定义最大的元素
        int delimeter = 0;//定义最大元素所在的位置
        for(int i = begin; i < end; i++){
            if(nums[i] > max){
                max = nums[i];
                delimeter = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = findNode(nums, begin, delimeter);
        node.right = findNode(nums, delimeter+1, end);
        return node;
    }
}
