package 力扣真题.贪心算法.分发糖果.test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int candy(int[] nums){
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < len; i++){
            if(nums[i] > nums[i-1]){
                left[i] = left[i-1] + 1;
            }
        }
        for(int i = len -2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                right[i] = right[i+1] + 1;
            }
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
