package 力扣真题.动态规划.解码方法.error;

/**
 * @Description 这个算法是错误的, 反例"2101"
 * @Author douzhenjun
 * @DATE 2024-07-03
 **/
public class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        if(chars[0] == '0'){
            return 0;
        }else{
            dp[0] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            String str = "" + chars[i-1] + chars[i];
            boolean isValid = false;
            if(Integer.parseInt(str) > 0 && Integer.parseInt(str) < 27){
                isValid = true;
            }
            if(chars[i] == '0' && !isValid){
                return 0;
            }
            if(chars[i] != '0' && isValid){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}
