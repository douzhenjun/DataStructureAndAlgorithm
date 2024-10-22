package 力扣真题.动态规划._01背包问题.目标和.回溯;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-05
 **/
public class Solution {
    
    private int result;
    public int findTargetSumWays(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return result;
    }
    
    public void backTracking(int[] nums, int target, int startIndex, int sum){
        if(startIndex == nums.length){
            if(sum == target){
                result++;
            }
            return;
        }
        sum += nums[startIndex];
        backTracking(nums, target, startIndex+1, sum);
        sum -= nums[startIndex];
        
        sum += nums[startIndex] * (-1);
        backTracking(nums, target, startIndex+1, sum);
        sum -= nums[startIndex] * (-1);
    }
}
