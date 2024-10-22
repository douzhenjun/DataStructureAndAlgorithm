package 华为面试模拟题.最长公共子串;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution2 {

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        String res = "";
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] ans = new int[l1 + 1][l2 + 1];
        int last1 = 0;
        int max = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1[i - 1] == s2[j - 1])
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                else
                    ans[i][j] = 0;
                if (ans[i][j] > max) {
                    max = ans[i][j];
                    last1 = i;
                }
            }
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                System.out.printf("%2d", ans[i][j]);
            }
            System.out.println();
        }
        
        for (int i = last1 - max; i < last1; i++) {
            res = res + s1[i];
        }
        return res;
    }
    
}
