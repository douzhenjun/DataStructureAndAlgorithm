package 力扣真题.动态规划.最长重复子数组;

/**
 * @Description
 * 定义二维数组dp[i][j]表示以nums[i]和nums[j]为末尾元素的数组的重复连续子数组的最大长度.
 * 考虑0的情况,
 * 所以int[][]dp = new int[nums1.length+1][nums2.length+1]
 * 并且dp[0][j]=0;dp[i][0]=0;
 * 对于dp[i][j], 如果nums1[i]==nums2[j]成立,那么dp[i][j]=Math.max(dp[i-1][j]+1,dp[i][j-1]+1)
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
