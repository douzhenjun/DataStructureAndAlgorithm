package 力扣真题.贪心算法.摆动序列.test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution2 {
    public int wiggleMaxLength(int[] nums){
        if(nums.length <= 1){
            return nums.length;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = dp[i][1] = 1;
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
