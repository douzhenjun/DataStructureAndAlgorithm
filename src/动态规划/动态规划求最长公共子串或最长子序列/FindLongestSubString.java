package 动态规划.动态规划求最长公共子串或最长子序列;

public class FindLongestSubString {
    public static int[] maxLong(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return null;
        }
        int max = 0;
        int maxI = -1;
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
                    dp[i][j] = 0;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                    maxI = i;
                }
            }
        }
        int[] arr = {max, maxI};
        return arr;
    }

    public static void main(String[] args) {
        String str1 = "acdefh";
        String str2 = "abcdegh";
        int[] arr = maxLong(str1, str2);
        System.out.println("最长的公共子串为:");
        for(int i = arr[1]-arr[0]; i < arr[1]; i++){
            System.out.print(str1.charAt(i));
        }
        System.out.println();
        System.out.println("最长公共子串的长度为:"+arr[0]);
    }
}
