package 力扣真题.动态规划.最长连续递增子序列;

/**
 * @Description
 * 考虑dp[i][j]表示数组中的前i个元素在以nums[j]为末尾的连续递增的子序列的最长长度.j <= i
 * 如果nums[j]>nums[j-1],那么考虑dp[i][j-1]+1的长度和dp[i][k]的长度取最大值
 * dp[i][j]=Math.max(dp[i][j-1]+1,dp[i][j-2],...dp[i][0])
 * 否则dp[i][j]=dp[i][j-1]
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int findLengthOfLCIS(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else{
                    if(nums[j] > nums[j-1]){
                        dp[i][j] = dp[i][j-1]+1;
                    }else{
                        dp[i][j] = 1;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
