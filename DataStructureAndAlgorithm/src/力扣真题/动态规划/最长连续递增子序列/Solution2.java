package 力扣真题.动态规划.最长连续递增子序列;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution2 {
    public int findLengthOfLCIS(int[] nums){
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);//初始化
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[i-1]){
                    dp[i] = dp[i-1]+1;
                }else{
                    dp[i] = 1;
                }
                res = Math.max(res, dp[j]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
