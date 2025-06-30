package 力扣真题.动态规划.解码方法;

import 力扣真题.动态规划.解码方法.error.Solution;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-03
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "12";
        String s3 = "06";
        System.out.println(solution.numDecodings(s1));
        System.out.println(solution.numDecodings(s3));
    }
}
