package 力扣真题.贪心算法.最大子序和;

/**
 * @Description
 * 局部最优:和为负数则停止计算和
 * 整体最优:具有最大和的连续子数组
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int maxSubArray(int[] nums){
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > result){
                result = sum;
            }
            if(sum <= 0){
                sum = 0;
            }
        }
        return result;
    }
}
