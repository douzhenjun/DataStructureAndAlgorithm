package 力扣真题.数组.在排序数组中找到目标元素的第一个和最后一个位置;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-23
 **/
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        if(leftBorder == -2 || rightBorder == -2){
            return new int[] {-1, -1};
        }
        if(rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        return new int[]{-1, -1};
    }

    private int searchLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }

    private int searchRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}
