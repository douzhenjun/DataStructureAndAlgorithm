package 力扣真题.动态规划.最长递增子序列;

import java.util.Arrays;

/**
 * @Description 二维数组超时了,采用一维数组
 * dp[j]表示数组的前i个元素以nums[j]为末尾的数组所组成的最大严格递增子序列的长度, i=0,1,2,... 
 * dp[0]=1,i任意
 * 对于j<i,如果nums[i]>nums[j]成立,那么一定有dp[i]=dp[j]+1,遍历j<i,找到最大的那个更新dp[i]
 * 又因为对于任意的i来说,dp[j]表示的结果取最大的那个就是前i个元素组成的数组中最长的那个递增子序列的长度了.
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution2 {
    public int lengthOfLIS(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    //考虑当前的元素nums[i]大于nums[j],那么这个dp[i]就可能是dp[j]+1,取
                    //所有结果中最大的
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
