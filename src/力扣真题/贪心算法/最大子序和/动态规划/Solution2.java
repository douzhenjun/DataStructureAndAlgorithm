package 力扣真题.贪心算法.最大子序和.动态规划;

/**
 * @Description 
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回具有最大和的连续子数组。
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution2 {
    public int[] maxSubArray(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        int result = Integer.MIN_VALUE;
        int[] index = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(j > i){
                    dp[i][j] += dp[i][j-1];
                }
                dp[i][j] = nums[i];
                if(dp[i][j] > result){
                    result = dp[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        int[] resultArray = new int[index[1]-index[0]+1];
        for(int i = index[0]; i < index[1]+1; i++){
            resultArray[i-index[0]] = nums[i];
        }
        return resultArray;
    }
}
