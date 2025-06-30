package 力扣真题.动态规划.完全背包问题.单词拆分.回溯;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-08
 **/
public class TestDemos {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordArray = {"leet", "code"};
        List<String> wordDict = Arrays.asList(wordArray);
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));

        String s2 = "applepenapple";
        String[] wordArray2 = {"apple", "pen"};
        System.out.println(solution.wordBreak(s2, Arrays.asList(wordArray2)));

        String s3 = "catsandog";
        String[] wordArray3 = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(solution.wordBreak(s3, Arrays.asList(wordArray3)));
    }
}
