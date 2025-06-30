package 动态规划.动态规划求最长公共子串或最长子序列;

public class FindLongestSubSequence {
    public static int maxLong(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 1; i <=str1.length(); i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j < str2.length(); j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "acbcff";
        System.out.println(str1+"和"+str2+"最长的公共子序列长度为:" + maxLong(str1, str2));
    }
}
