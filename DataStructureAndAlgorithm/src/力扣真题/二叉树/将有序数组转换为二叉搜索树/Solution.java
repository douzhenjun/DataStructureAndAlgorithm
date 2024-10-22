package 力扣真题.二叉树.将有序数组转换为二叉搜索树;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

/**
 * @Description 每次取中间的元素作为根节点,再按照左右分隔的区间递归执行,直到递归的边界条件满足
 * @Author douzhenjun
 * @DATE 2024-02-26
 **/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length == 0){
            return null;
        }
        return construct(nums, 0, nums.length-1);
    }
    public TreeNode construct(int[] nums, int begin, int end){
        if(begin > end){
            return null;
        }
        int mid = begin + (end-begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, begin, mid-1);
        root.right = construct(nums, mid+1, end);
        return root;
    }
}
