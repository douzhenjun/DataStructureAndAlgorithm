package 力扣真题.贪心算法.摆动序列.动态规划;

/**
 * @Description dp[i][0]表示以第i个元素为波峰时,前i个元素的序列中最长的摆动子序列长度
 *              dp[i][1]表示以第i个元素为波谷时,前i个元素的序列中最长的摆动子序列长度
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class Solution {
    public int wiggleMaxLength(int[] nums){
        //0 i作为波峰的最大长度
        //1 i作为波谷的最大长度
        int dp[][] = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = dp[i][1] = 1;//前i个元素
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[i]){
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if(nums[j] < nums[i]){
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
