package 力扣真题.动态规划.最长递增子序列;

/**
 * @Description 考虑dp[i][j]表示数组nums[0-i]中以nums[j]为末尾的最长严格递增子序列的长度
 * 显然dp[i][j] = 0, j>i;
 * 初始化
 * dp[0][0] = 1;
 * 对于i>0,dp[i][j]=Math.max(dp[i][k])+1,k<j,并且nums[j]>nums[k]
 * 所以逻辑应该这么写
 * for(int i =1; i<nums.length;i++){
 * for(int j=0;j<=i;j++){
 * for(int k=0;k<j;k++){
 * <p>
 * }
 * }
 * }
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = 1;//初始化
                } else {
                    dp[i][j] = 1;
                    //考虑nums[j]和nums[k]的大小,
                    for (int k = 0; k < j; k++) {
                        if (nums[j] > nums[k]) {
                            dp[i][j] = Math.max(dp[i][j], dp[i][k] + 1);
                        }
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
