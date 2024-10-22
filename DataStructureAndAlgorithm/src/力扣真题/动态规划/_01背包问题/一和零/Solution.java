package 力扣真题.动态规划._01背包问题.一和零;

/**
 * @Description
 * 考虑一个背包,它能装进0的个数为m,1的个数为n,求它能装进的商品strs[i]的最大个数
 * nums0[i]表示strs[i]中0的个数
 * nums1[i]表示strs[i]中1的个数
 * 定义dp二维数组dp[i][j1][j2]表示将strs[0-i]这些元素装进容量为(j1,j2)的背包所能容纳的最多元素个数.
 * 
 * 初始化
 * dp[0][j1][j2],要看nums0[0]<=j1&&nums1[0]<=j2成立,则dp[0][j1][j2]=1;否则为0.
 * dp[i][0][0]=0是显然的.
 * dp[i][j1][j2]要分情况,如果nums0[i]>j1||nums0[i]>j2成立,那么dp[i][j1][j2]=dp[i-1][j1][j2].
 * 否则,dp[i][j1][j2]=Math.max(dp[i-1][j1][j2],dp[i-1][j1-nums0[i]][j2-nums1[i]]+1)
 * @Author douzhenjun
 * @DATE 2024-03-05
 **/
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //初始化nums0,nums1
        int[] nums0 = new int[strs.length];
        int[] nums1 = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '0'){
                    nums0[i]++;
                }else{
                    nums1[i]++;
                }
            }
        }
        int[][][] dp = new int[strs.length][m+1][n+1];
        //对i=0初始化
        for(int j1 = 0; j1 < m+1; j1++){
            for(int j2 = 0; j2 < n+1; j2++){
                if(j1 >= nums0[0] && j2 >= nums1[0]){
                    dp[0][j1][j2] = 1;
                }
            }
        }
        for(int i = 1; i < strs.length; i++){
            for(int j1 = 0; j1 < m+1; j1++){
                for(int j2 = 0; j2 < n+1; j2++){
                    if(nums0[i] > j1 || nums1[i] > j2){
                        dp[i][j1][j2] = dp[i-1][j1][j2];
                    }else{
                        dp[i][j1][j2] = Math.max(dp[i-1][j1][j2], dp[i-1][j1-nums0[i]][j2-nums1[i]]+1);
                    }
                }
            }
        }
        
        //打印dp
        for(int i = 0; i < strs.length; i++){
            for(int j1 = 0; j1 < m+1; j1++) {
                for (int j2 = 0; j2 < n + 1; j2++) {
                    System.out.printf("%2d",dp[i][j1][j2]);
                }
            }
            System.out.println();
        }
        return dp[strs.length-1][m][n];
    }
}
